package com.inversionas.labs.client.java.ig.autoconfigure;

import com.inversionas.labs.client.java.ig.IGRestTradingApiConfiguration;
import com.inversionas.labs.client.java.ig.IGStreamingApiConfiguration;
import com.inversionas.labs.client.java.ig.feign.IGErrorDecoder;
import com.inversionas.labs.client.java.ig.feign.SessionDecoder;
import com.inversionas.labs.client.java.ig.model.session.SessionContext;
import com.inversionas.labs.client.java.ig.model.session.SessionRequest;
import com.inversionas.labs.client.java.ig.services.SessionService;
import com.inversionas.labs.client.java.ig.properties.IGClientProperties;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;

import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.slf4j.Slf4jLogger;
import lombok.extern.slf4j.Slf4j;

@Configuration
@Import({IGRestTradingApiConfiguration.class, IGStreamingApiConfiguration.class})
@Slf4j
public class IGAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(value = "ig.host")
    public IGClientProperties igClientProperties(Environment env) {
        IGClientProperties properties = new IGClientProperties();
        properties.setHost(env.getRequiredProperty("ig.host"));
        properties.setToken(env.getRequiredProperty("ig.token"));
        properties.setUser(env.getRequiredProperty("ig.user"));
        properties.setPassword(env.getRequiredProperty("ig.password"));
        return properties;
    }

    /**
     * For every request to IG we need a SessionContext to be passed on every request.
     * SessionContext is valid for One Hou
     */
    @Bean
    @ConditionalOnMissingBean
    public SessionContext sessionService(IGClientProperties properties) {

        // TODO: Refresh Application Context based on SessionContext refresh time out ??

        log.trace("Trying to authenticate ...");

        SessionService service = Feign.builder().logger(new Slf4jLogger()).encoder(new GsonEncoder())
                .decoder(new SessionDecoder(new GsonDecoder())).errorDecoder(new IGErrorDecoder())
                .target(SessionService.class, properties.getHost());

        SessionRequest request = new SessionRequest();
        request.setEncryptedPassword(false);
        request.setIdentifier(properties.getUser());
        request.setPassword(properties.getPassword());
        final String apiToken = properties.getToken();

        SessionContext sessionContext =  service.createSession(request, apiToken);
        log.warn("Application was authenticated. ClientID: {}", sessionContext.getClientId());

        return sessionContext;
    }
}
