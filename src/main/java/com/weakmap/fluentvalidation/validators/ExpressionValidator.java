package com.weakmap.fluentvalidation.validators;

import com.weakmap.fluentvalidation.PropertyValidator;

import java.util.function.Function;

public class ExpressionValidator<TProperty> extends PropertyValidator<TProperty> {

    private final Function<TProperty, Boolean> expression;

    public ExpressionValidator(Function<TProperty, Boolean> expression) {
        this.expression = expression;
    }

    public Boolean validate(TProperty value) {
        return expression.apply(value);
    }
}
