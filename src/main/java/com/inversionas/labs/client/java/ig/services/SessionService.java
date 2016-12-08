package com.inversionas.labs.client.java.ig.services;

import com.inversionas.labs.client.java.ig.model.session.SessionContext;
import com.inversionas.labs.client.java.ig.model.session.SessionRequest;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface SessionService {

    @RequestLine("POST /deal/session")
    @Headers({"Accept: application/json; charset=UTF-8", "Content-Type: application/json; charset=UTF-8", "Version: 2", "X-IG-API-KEY: {igApiKey}"})
    public SessionContext createSession(SessionRequest request, @Param("igApiKey") String igApiKey);
}
