package com.inversionas.labs.client.java.ig.services;

import com.inversionas.labs.client.java.ig.model.prices.PriceResolution;
import com.inversionas.labs.client.java.ig.model.prices.PricesResponse;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface PricesService {

    @RequestLine("GET /deal/prices/{epic}?resolution={resolution}&max={numPoints}&pageSize=0")
    @Headers({"Accept: application/json; charset=UTF-8", "Content-Type: application/json; charset=UTF-8"
            , "X-IG-API-KEY: {igApiKey}"
            , "X-SECURITY-TOKEN: {xSecurityToken}"
            , "CST: {cst}"
            , "Version: 3"})
    public PricesResponse getPrices(@Param("epic") String epic, @Param("resolution") PriceResolution priceResolution, @Param("numPoints") int numPoints,
                                    @Param("cst") String cst, @Param("xSecurityToken") String xSecurityToken, @Param("igApiKey") String igApiKey);
}
