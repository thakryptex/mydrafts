package com.innopolis.tests.bootcamp.firstbankofkazan.exceptions;

public class TooManyCustomersException extends Exception {
    public TooManyCustomersException(String description) {
        super(description);
    }
}
