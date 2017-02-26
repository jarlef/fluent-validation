package com.weakmap.fluentvalidation;

public class ValidationError {
    private String message;

    ValidationError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
