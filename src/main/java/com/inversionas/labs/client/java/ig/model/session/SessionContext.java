package com.inversionas.labs.client.java.ig.model.session;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * Summary of client account information returned on successful client login. <br/>
 * <br/>
 *
 * Two security access tokens are returned in the response header, and are
 * required to be submitted via the header in future API requests:
 * <ul>
 * <li>CST - Client session security access token</li>
 * <li>X-SECURITY-TOKEN - Account session security access token</li>
 * </ul>
 *
 * This is used by the v2 Authentication PAPI endpoint
 */
@Getter
@Setter
public class SessionContext {

    private String cst;

    private String xSecurityToken;

    private AccountType accountType;

    /**
     * Active account summary
     */
    private AccountInfo accountInfo;

    /**
     * Account currency
     */
    private String currencyIsoCode;

    /**
     * Account currency symbol
     */
    private String currencySymbol;

    /**
     * Active account identifier
     */
    private String currentAccountId;

    /**
     * Lightstreamer endpoint for subscribing to account and price updates
     */
    private String lightstreamerEndpoint;

    /**
     * Client account summaries
     */
    private List<AccountsItem> accounts;

    /**
     * Client identifier
     */
    private String clientId;

    /**
     * Client account timezone offset relative to UTC, expressed in hours
     */
    private int timezoneOffset;

    /**
     * Whether the Client has active demo accounts.
     */
    private Boolean hasActiveDemoAccounts;

    /**
     * Whether the Client has active live accounts.
     */
    private Boolean hasActiveLiveAccounts;

    /**
     * Whether the account is allowed to set trailing stops on his trades
     */
    private Boolean trailingStopsEnabled;

    /**
     * If specified, indicates that the authentication process requires the client to switch to a
     * different URL in order to complete the login.
     * <p/>
     * If null, no rerouting has to take place and the authentication process is complete.
     * <p/>
     * This is expected for any DEMO clients, where the authentication process is initiated against
     * the production servers (i.e. https://api.ig.com/gateway/deal ) whereas all subsequent
     * requests have to be issued against the DEMO servers (i.e. https://demo-api.ig.com/gateway/deal
     * )
     * <p/>
     * Please also note that when rerouting to DEMO it is also required to invoke to "silent login"
     * endpoint in DEMO with the CST token obtained by the preceding LIVE authentication endpoint
     * invocation.
     * <p/>
     * Please consult the http://labs.ig.com site for more details about the login rerouting
     * details.
     */
    private ReroutingEnvironment reroutingEnvironment;

    /**
     * Whether the account is enabled for placing trading orders
     */
    private Boolean dealingEnabled;

    /**
     * The ig company that this client belongs to
     */
    private String igCompany;

    /**
     * Flag indicating if the request was marked as being encrypted
     */
    private boolean encrypted;

    /**
     * List of forms details
     */
    private java.util.List<FormDetailsItem> formDetails;

    /**
     * Authentication status
     */
    private AuthenticationStatus authenticationStatus;
}
