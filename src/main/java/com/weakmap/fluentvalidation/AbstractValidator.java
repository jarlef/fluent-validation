package com.weakmap.fluentvalidation;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class AbstractValidator<T> implements Validator<T> {

    private List<ValidatePropertyRules<T>> rules;

    protected AbstractValidator() {
        rules = new ArrayList<>();
    }

    protected <TProperty> PropertyRule<T, TProperty> ruleFor(Function<T, TProperty> property) {
        PropertyRuleImpl<T, TProperty> rule = new PropertyRuleImpl<>(property);
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
