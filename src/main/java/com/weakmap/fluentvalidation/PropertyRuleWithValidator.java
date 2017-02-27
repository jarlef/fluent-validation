package com.weakmap.fluentvalidation;

public interface PropertyRuleWithValidator<T, TProperty> extends PropertyRule<T, TProperty> {
    PropertyRuleWithValidator<T, TProperty> withMessage(String message);
}
