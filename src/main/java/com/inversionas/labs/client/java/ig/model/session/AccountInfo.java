package com.inversionas.labs.client.java.ig.model.session;

import lombok.Getter;
import lombok.Setter;

/**
 * Account financial data
 */
@Getter
@Setter
public class AccountInfo {

    /**
     * Balance of funds in the account
     */
    private Float balance;

    /**
     * Minimum deposit amount required for margins
     */
    private Float deposit;

    /**
     * Account profit and loss amount
     */
    private Float profitLoss;

    /**
     * Account funds available for trading amount
     */
    private Float available;
}
