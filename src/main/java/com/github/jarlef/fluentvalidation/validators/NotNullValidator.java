package com.github.jarlef.fluentvalidation.validators;

import com.github.jarlef.fluentvalidation.PropertyValidator;

public class NotNullValidator<TProperty> extends PropertyValidator<TProperty> {

    public NotNullValidator() {
        super.setMessage("{propertyName} cannot be null");
    }

    @Override
    public Boolean validate(TProperty value) {
        return value != null;
    }
}
