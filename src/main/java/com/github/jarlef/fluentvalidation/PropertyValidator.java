package com.github.jarlef.fluentvalidation;

public abstract class PropertyValidator<TProperty> {

    private String message;

    protected PropertyValidator() {
        message = "";
    }

    public abstract Boolean validate(TProperty value);

    protected void setMessage(String message) {
        this.message = message;
    }

    String getFormattedMessage(String propertyName, TProperty value) {
        return message.replace("{propertyName}", propertyName).replace("{value}", value != null ? value.toString() : "");
    }
}

