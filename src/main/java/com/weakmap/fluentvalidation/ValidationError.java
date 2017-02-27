package com.weakmap.fluentvalidation;

public class ValidationError {
    private final String propertyName;
    private String message;

    ValidationError(String propertyName, String message) {
        this.propertyName = propertyName;
        this.message = message;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public String getMessage() {
        return message;
    }


}
