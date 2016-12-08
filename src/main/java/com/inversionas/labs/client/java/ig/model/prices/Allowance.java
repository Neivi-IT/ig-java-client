package com.inversionas.labs.client.java.ig.model.prices;

import lombok.Getter;
import lombok.Setter;

/**
 * Historical price data allowance
 */
@Getter
@Setter
public class Allowance {

    /**
     * The number of data points still available to fetch within the current allowance period
     */
    private Integer remainingAllowance;

    /**
     * The number of data points the API key and account combination is allowed to fetch in any
     * given allowance period
     */
    private Integer totalAllowance;

    /**
     * The number of seconds till the current allowance period will end and the remaining allowance
     * field is reset
     */
    private Integer allowanceExpiry;
}
