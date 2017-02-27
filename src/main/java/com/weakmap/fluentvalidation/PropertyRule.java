package com.weakmap.fluentvalidation;

import java.util.function.Function;

@SuppressWarnings("all")
public interface PropertyRule<T, TProperty>  {
    PropertyRuleWithValidator<T, TProperty> must(Function<TProperty, Boolean> expression);
    PropertyRuleWithValidator<T, TProperty> notNull();
    PropertyRuleWithValidator<T, TProperty> notEmpty();
    PropertyRuleWithValidator<T, TProperty> minLength(int length);
    PropertyRuleWithValidator<T, TProperty> maxLength(int length);
    PropertyRuleWithValidator<T, TProperty> using(Validator<TProperty> validator);
}
