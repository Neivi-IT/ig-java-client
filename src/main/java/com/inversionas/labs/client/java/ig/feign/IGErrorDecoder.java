package com.inversionas.labs.client.java.ig.feign;

import com.inversionas.labs.client.java.ig.exceptions.IGRuntimeException;

import java.io.IOException;

import feign.Response;
import feign.codec.ErrorDecoder;
import feign.gson.GsonDecoder;
import lombok.extern.slf4j.Slf4j;

/**
 * Tranlates an error response to an application exception
 */
@Slf4j
public class IGErrorDecoder implements ErrorDecoder {

    private GsonDecoder gsonDecoder = new GsonDecoder();

    @Override
    public Exception decode(String methodKey, Response response) {

        log.debug("Status Code: {}", response.status());
        log.debug("Reason: {}", response.reason());
        try {
            ErrorInfo ei = (ErrorInfo) gsonDecoder.decode(response, ErrorInfo.class);
            if (ei != null) {
                log.debug("Error Info: {}", ei);
            }
        } catch (IOException e) {
        }
        return new IGRuntimeException();
    }

}
