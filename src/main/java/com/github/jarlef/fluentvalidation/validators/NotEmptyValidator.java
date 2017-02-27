package com.github.jarlef.fluentvalidation.validators;

import com.github.jarlef.fluentvalidation.PropertyValidator;

import java.util.Collection;
import java.util.Collections;

public class NotEmptyValidator<TProperty> extends PropertyValidator<TProperty> {

    public NotEmptyValidator() {
        super.setMessage("{propertyName} cannot be empty");
    }

    @Override
    public Boolean validate(TProperty value) {
        if(value == null) {
            return false;
        }

        if(value instanceof String) {
            String s = (String) value;
            return s.length() > 0;
        }

        if(value instanceof Collections) {
            Collection s = (Collection) value;
            return s.size() > 0;
        }

        return DefaultValues.defaultValueFor(value.getClass()) != value;
    }
}
