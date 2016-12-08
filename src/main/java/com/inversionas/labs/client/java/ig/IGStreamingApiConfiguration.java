package com.inversionas.labs.client.java.ig;

import com.inversionas.labs.client.java.ig.autoconfigure.IGAutoConfiguration;
import com.inversionas.labs.client.java.ig.model.session.SessionContext;
import com.inversionas.labs.client.java.ig.streaming.StreamingAPI;
import com.lightstreamer.client.Subscription;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

/**
 *
 * STREAMING API Configuration
 *
 */
@Configuration
@ConditionalOnProperty("ig.streaming.enabled")
@AutoConfigureAfter(value = IGAutoConfiguration.class)
@Slf4j
public class IGStreamingApiConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public StreamingAPI streamingAPI(SessionContext context, List<Subscription> subscriptions) {
        log.warn("Configuring Streaming API ... ");
        return new StreamingAPI(context, subscriptions);
    }
}
