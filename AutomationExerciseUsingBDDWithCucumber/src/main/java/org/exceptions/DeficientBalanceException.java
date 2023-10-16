package org.exceptions;

public class DeficientBalanceException extends Exception {
    public DeficientBalanceException(String message) {
        super(message);
    }
}