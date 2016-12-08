package com.inversionas.labs.client.java.ig.feign;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Error reponses body.
 */
// TODO: Analize the error responses to implement
@Getter
@Setter
@ToString
public class ErrorInfo {
    String errorCode;
}
