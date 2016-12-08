package com.inversionas.labs.client.java.ig.model.session;

import lombok.Getter;
import lombok.Setter;

/**
 * Client login credentials
 */
@Getter
@Setter
public class SessionRequest {

    /**
     * Client login identifier
     */
    private String identifier;

    /**
     * Client login password
     */
    private String password;

    /**
     * Whether the password has been sent encrypted.
     */
    private Boolean encryptedPassword;
}
