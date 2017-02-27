package com.weakmap.fluentvalidation.validators;

import com.weakmap.fluentvalidation.PropertyValidator;

public class NotNullValidator<TProperty> extends PropertyValidator<TProperty> {

    public NotNullValidator() {
        super.setMessage("{propertyName} cannot be null");
    }

    @Override
    public Boolean validate(TProperty value) {
        return value != null;
    }
}
