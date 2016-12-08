package com.inversionas.labs.client.java.ig.streaming;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by X11443AL on 24/11/2016.
 */
@Setter
@Getter
@ToString
public class StreamingSettings {

    private String host;
    private String password;
    private String accountId;

    public StreamingSettings(String host, String cst, String xSecurityToken, String accountId) {
        this.host = host;
        this.password = "CST-" + cst + "|XST-" + xSecurityToken;
        this.accountId = accountId;
    }

    public String getUser() {
        return getAccountId();
    }
}
