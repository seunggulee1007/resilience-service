package com.resilience.resilienceservice.exception;

public class RetryException extends RuntimeException {

    public RetryException() {
        super();
    }
    public RetryException(String retryException) {
        super(retryException);
    }

}
