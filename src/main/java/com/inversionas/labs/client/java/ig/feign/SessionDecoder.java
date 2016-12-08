package com.inversionas.labs.client.java.ig.feign;

import com.inversionas.labs.client.java.ig.model.session.SessionContext;
import com.inversionas.labs.client.java.ig.utils.IGConstants;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Map;

import feign.FeignException;
import feign.Response;
import feign.codec.DecodeException;
import feign.codec.Decoder;
import feign.gson.GsonDecoder;
import lombok.extern.slf4j.Slf4j;

/**
 * IG response headers to be mapped to SessionContext bean.
 */
@Slf4j
public class SessionDecoder implements Decoder {

    private GsonDecoder gsonDecoder;

    public SessionDecoder(GsonDecoder gsonDecoder) {
        this.gsonDecoder = gsonDecoder;
    }

    @Override
    public Object decode(Response response, Type type) throws IOException, DecodeException, FeignException {
        Object o = gsonDecoder.decode(response, type);

        if (o instanceof SessionContext) {
            SessionContext sr = (SessionContext) o;
            Map<String, Collection<String>> headers = response.headers();
            if (headers.containsKey(IGConstants.HEADER_CST)) {
                headers.get(IGConstants.HEADER_CST).stream().forEach(s -> sr.setCst(s));
            }

            if (headers.containsKey(IGConstants.HEADER_X_SECURITY_TOKEN)) {
                headers.get(IGConstants.HEADER_X_SECURITY_TOKEN).stream().forEach(s -> sr.setXSecurityToken(s));
            }
        }

        return o;

    }
}