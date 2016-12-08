package com.inversionas.labs.client.java.ig.model.prices;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

/*
Price
*/
@Getter
@Setter
public class LowPrice {

    /*
    Bid price
    */
    private BigDecimal bid;

    /*
    Ask price
    */
    private BigDecimal ask;

    /*
    Last traded price.  This will generally be null for non exchange-traded instruments
    */
    private BigDecimal lastTraded;

}
