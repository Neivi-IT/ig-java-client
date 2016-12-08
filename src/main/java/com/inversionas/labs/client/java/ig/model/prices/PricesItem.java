package com.inversionas.labs.client.java.ig.model.prices;

import lombok.Getter;
import lombok.Setter;

/**
 * Historical market price snapshot
 */
@Setter
@Getter
public class PricesItem {

    /**
     * Snapshot local time, format is yyyy/MM/dd hh:mm:ss
     */
    private String snapshotTime;

    private OpenPrice openPrice;

    private ClosePrice closePrice;

    private HighPrice highPrice;

    private LowPrice lowPrice;

    private Long lastTradedVolume;
}
