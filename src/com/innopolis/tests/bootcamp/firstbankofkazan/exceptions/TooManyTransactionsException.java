package com.innopolis.tests.bootcamp.firstbankofkazan.exceptions;

public class TooManyTransactionsException extends Exception {
    public TooManyTransactionsException(String description) {
        super(description);
    }
}
