package com.weakmap.fluentvalidation;

import com.weakmap.fluentvalidation.validators.ChildValidationValidator;
import com.weakmap.fluentvalidation.validators.ExpressionValidator;
import com.weakmap.fluentvalidation.validators.MaxLengthValidator;
import com.weakmap.fluentvalidation.validators.MinLengthValidator;
import com.weakmap.fluentvalidation.validators.NotEmptyValidator;
import com.weakmap.fluentvalidation.validators.NotNullValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

class PropertyRuleImpl<T, TProperty> implements PropertyRule<T, TProperty>, ValidatePropertyRules<T> {

    private final Function<T, TProperty> property;
    private final List<PropertyValidator<TProperty>> propertyValidators;

    PropertyRuleImpl(Function<T, TProperty> property) {
        this.property = property;
        this.propertyValidators = new ArrayList<>();
    }

    @Override
    public PropertyRule<T, TProperty> must(Function<TProperty, Boolean> expression) {
        propertyValidators.add(new ExpressionValidator<>(expression));
        return this;
    }

    @Override
    public PropertyRule<T, TProperty> notNull() {
        propertyValidators.add(new NotNullValidator<>());
        return this;
    }

    @Override
    public PropertyRule<T, TProperty> notEmpty() {
       propertyValidators.add(new NotEmptyValidator<>());
        return this;
    }

    @Override
    public PropertyRule<T, TProperty> minLength(int length) {
        propertyValidators.add(new MinLengthValidator<>(length));
        return this;
    }

    @Override
    public PropertyRule<T, TProperty> maxLength(int length) {
        propertyValidators.add(new MaxLengthValidator<>(length));
        return this;
    }

    @Override
    public PropertyRule<T, TProperty> using(Validator<TProperty> validator) {
        propertyValidators.add(new ChildValidationValidator<>(validator));
        return this;
    }


    @Override
    public ValidationResult validate(T instance) {

        TProperty value = this.property.apply(instance);
        List<ValidationError> errors = new ArrayList<>();

        for(PropertyValidator<TProperty> propertyValidator : propertyValidators) {
            Boolean result = propertyValidator.validate(value);

            if(!result) {
                errors.add(new ValidationError("Some error"));
                return ValidationResult.create(errors.toArray(new ValidationError[0]));
            }
        }

        return ValidationResult.create();
    }
}
