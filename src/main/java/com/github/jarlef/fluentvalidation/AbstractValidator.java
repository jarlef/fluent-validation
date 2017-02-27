package com.github.jarlef.fluentvalidation;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class AbstractValidator<T> implements Validator<T> {

    private List<ValidatePropertyRules<T>> rules;

    protected AbstractValidator() {
        rules = new ArrayList<>();
    }

    protected <TProperty> PropertyRule<T, TProperty> ruleFor(Function<T, TProperty> property) {
        return this.ruleFor(property, null);
    }

    protected <TProperty> PropertyRule<T, TProperty> ruleFor(Function<T, TProperty> property, String propertyName) {
        PropertyRuleImpl<T, TProperty> rule = new PropertyRuleImpl<>(property, propertyName);
        rules.add(rule);
        return rule;
    }

    public ValidationResult validate(T instance) {
        ValidationResult result = ValidationResult.create();

        for(ValidatePropertyRules<T> rule : rules) {
            result = ValidationResult.merge(result, rule.validate(instance));
        }

        return result;
    }
}
