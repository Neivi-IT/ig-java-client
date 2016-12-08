package com.inversionas.labs.client.java.ig.streaming;

import com.inversionas.labs.client.java.ig.streaming.enums.IGClientStatus;
import com.inversionas.labs.client.java.ig.model.session.SessionContext;
import com.inversionas.labs.client.java.ig.streaming.lightstreamer.Slf4jLoggerProvider;
import com.lightstreamer.client.ClientListener;
import com.lightstreamer.client.LightstreamerClient;
import com.lightstreamer.client.Subscription;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StreamingAPI {

    private static final String TRADE_PATTERN = "TRADE:{accountId}";
    private static final String ACCOUNT_BALANCE_INFO_PATTERN = "ACCOUNT:{accountId}";
    private static final String MARKET_L1_PATTERN = "MARKET:{epic}";
    private static final String SPRINT_MARKET_PATTERN = "MARKET:{epic}";
    private static final String CHART_TICK_PATTERN = "CHART:{epic}:TICK";
    private static final String CHART_CANDLE_PATTERN = "CHART:{epic}:{scale}";

    private LightstreamerClient client;
    private List<Subscription> subscriptions;

    public StreamingAPI(SessionContext sessionContext, List<Subscription> subscriptions) {

        // Informacion para conectarse al Streaming API
        StreamingSettings streamingSettings = new StreamingSettings(sessionContext.getLightstreamerEndpoint(), sessionContext.getCst(),
                sessionContext.getXSecurityToken(), sessionContext.getCurrentAccountId());

        log.debug("Streaming Settings: {}", streamingSettings);
        client = new LightstreamerClient(streamingSettings.getHost(), "PROD");
        client.setLoggerProvider(new Slf4jLoggerProvider());
        client.connectionDetails.setUser(streamingSettings.getUser());
        client.connectionDetails.setPassword(streamingSettings.getPassword());
        client.connectionDetails.setAdapterSet("DEFAULT");

        client.addListener(new StatusListener());

        subscriptions.stream().forEach(subscription -> client.subscribe(subscription));

        client.connect();

        log.debug("Client status: {}", client.getStatus());
    }

    static class StatusListener implements ClientListener {


        @Override
        public void onListenEnd(LightstreamerClient client) {
            // we never call removeListener, thus this never happen
        }

        @Override
        public void onListenStart(LightstreamerClient client) {
            log.debug("Status: " + client.getStatus());
        }

        @Override
        public void onPropertyChange(String property) {
            log.debug("Property Changed: {}", property);
        }

        @Override
        public void onServerError(int id, String desc) {
            log.debug("Server Error -  Id: {} desc: {}", "" + id, desc);
        }

        @Override
        public void onStatusChange(String status) {
            switch (status) {
                case "DISCONNECTED":
                case "DISCONNECTED:WILL_RETRY":
                case "CONNECTING":
                case "CONNECTED:STREAM-SENSING":
                    changeStatus(IGClientStatus.DISCONNECTED);
                    break;
                case "CONNECTED:WS-STREAMING":
                case "CONNECTED:HTTP-STREAMING":
                    changeStatus(IGClientStatus.STREAMING);
                    break;
                case "CONNECTED:WS-POLLING":
                case "CONNECTED:HTTP-POLLING":
                    changeStatus(IGClientStatus.POLLING);
                    break;
                case "STALLED":
                    changeStatus(IGClientStatus.STALLED);
                    break;
            }
        }

        private void changeStatus(IGClientStatus status) {
            log.debug("Status Changed: {}", status.toString());
        }
    }

}
