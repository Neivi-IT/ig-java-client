package com.inversionas.labs.client.java.ig.model.session;

import lombok.Getter;
import lombok.Setter;

/**
 * Account details
 */
@Getter
@Setter
public class AccountsItem {

    /**
     * Account identifier
     */
    private String accountId;

    private String accountName;

    /**
     *Indicates whether this account is the client's preferred account
     */
    private Boolean preferred;

    private AccountType accountType;
}
