package com.inversionas.labs.client.java.ig.model.session;

import lombok.Getter;
import lombok.Setter;

/**
 * Form details
 */
@Getter
@Setter
public class FormDetailsItem {

    private FormType formType;

    /**
     * Form access url
     */
    private String formUrl;

    private String formTitle;

    /**
     * Indicates if a user can dismiss the form
     */
    private boolean formDismissible;
}
