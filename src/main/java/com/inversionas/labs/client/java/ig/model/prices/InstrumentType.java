package com.inversionas.labs.client.java.ig.model.prices;

/*
Instrument type
*/
public enum InstrumentType {

    BINARY,
    BUNGEE_CAPPED,
    BUNGEE_COMMODITIES,
    BUNGEE_CURRENCIES,
    BUNGEE_INDICES,
    COMMODITIES,
    CURRENCIES,
    INDICES,
    OPT_COMMODITIES,
    OPT_CURRENCIES,
    /**
     * Index options
     */
    OPT_INDICES,
    /**
     * FX options
     */
    OPT_RATES,
    /**
     * Share options
     */
    OPT_SHARES,
    RATES,
    SECTORS,
    SHARES,
    SPRINT_MARKET,
    TEST_MARKET,
    UNKNOWN;
}
