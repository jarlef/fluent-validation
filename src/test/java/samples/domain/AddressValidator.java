package samples.domain;

import com.weakmap.fluentvalidation.AbstractValidator;

@SuppressWarnings("all")
public class AddressValidator extends AbstractValidator<Address> {

    public AddressValidator() {
        ruleFor(Address::getStreetAddress).notEmpty();
        ruleFor(Address::getZipCode).notEmpty().minLength(4);
        ruleFor(Address::getCity).notEmpty();
    }
}
