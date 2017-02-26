package com.weakmap.fluentvalidation;

public interface PropertyValidator<TProperty> {
    Boolean validate(TProperty value);
}
