package com.inversionas.labs.client.java.ig;

import com.inversionas.labs.client.java.ig.autoconfigure.IGAutoConfiguration;
import com.inversionas.labs.client.java.ig.feign.IGErrorDecoder;
import com.inversionas.labs.client.java.ig.services.PricesService;
import com.inversionas.labs.client.java.ig.properties.IGClientProperties;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.slf4j.Slf4jLogger;
import lombok.extern.slf4j.Slf4j;

/**
 * REST TRADING API
 */
@Configuration
@ConditionalOnProperty("ig.rest.enabled")
@AutoConfigureAfter(value = IGAutoConfiguration.class)
@Slf4j
public class IGRestTradingApiConfiguration {

    /**
     *
     * @param properties
     * @return
     */
    @Bean
    @ConditionalOnMissingBean
    public PricesService pricesService(IGClientProperties properties) {
        log.warn("Configuring PricesService ... ");
        return Feign.builder()
                .logger(new Slf4jLogger())

                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .errorDecoder(new IGErrorDecoder())

                .target(PricesService.class, properties.getHost());
    }
}
