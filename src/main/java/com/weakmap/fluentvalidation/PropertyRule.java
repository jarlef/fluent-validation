package com.weakmap.fluentvalidation;

import java.util.function.Function;

@SuppressWarnings("all")
public interface PropertyRule<T, TProperty>  {
    PropertyRule<T, TProperty> must(Function<TProperty, Boolean> expression);
    PropertyRule<T, TProperty> notNull();
    PropertyRule<T, TProperty> notEmpty();
    PropertyRule<T, TProperty> minLength(int length);
    PropertyRule<T, TProperty> maxLength(int length);
    PropertyRule<T, TProperty> using(Validator<TProperty> validator);
}
