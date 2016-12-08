package com.inversionas.labs.client.java.ig;

import com.inversionas.labs.client.java.ig.streaming.handlers.GenericSubscriptionListener;
import com.lightstreamer.client.Subscription;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class SubscriptionsConfiguration {

    @Bean
    public Subscription ibex35Subscriptions() {

        String group = "MARKET:IX.D.IBEX.IDF.IP";
        return subscriptionByGroup(group);
    }

    @Bean
    public Subscription nasdaqSubscriptions() {

        String group = "IX.D.NASDAQ.IFD.IP";
        return subscriptionByGroup(group);
    }

    private Subscription subscriptionByGroup(String group) {
        log.info("subscribing to {}", group);

        String[] itemsArr = new String[]{"MARKET_STATE", "MARKET_DELAY", "UPDATE_TIME", "BID", "OFFER", "HIGH", "LOW", "CHANGE", "CHANGE_PCT"};

        Subscription stocks = new Subscription("MERGE", group, itemsArr);
        stocks.setRequestedSnapshot("yes");
        stocks.addListener(new GenericSubscriptionListener());
        return stocks;
    }
}
