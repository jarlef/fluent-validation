package samples.domain;

import com.weakmap.fluentvalidation.AbstractValidator;

@SuppressWarnings("all")
public class CustomerValidator extends AbstractValidator<Customer> {

    public CustomerValidator() {
        ruleFor(Customer::getCustomerId).notEmpty().must(this::customerExists);
        ruleFor(c -> c.getName()).notEmpty().must(name -> name.equals("John"));
        ruleFor(Customer::getAddress).notEmpty().using(new AddressValidator());
    }

    private boolean customerExists(int id) {
        return id == 1;
    }
}




































