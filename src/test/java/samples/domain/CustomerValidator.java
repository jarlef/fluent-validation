package samples.domain;

import com.weakmap.fluentvalidation.AbstractValidator;

@SuppressWarnings("all")
public class CustomerValidator extends AbstractValidator<Customer> {

    public CustomerValidator() {
        ruleFor(Customer::getCustomerId, "customer id").notEmpty()
                                                                    .must(this::customerExists).withMessage("Customer does not exist");
        ruleFor(c -> c.getName(), "name").notEmpty().must(name -> name.equals("John")).withMessage("Hey {value}. You are not John");
        ruleFor(Customer::getAddress).notEmpty().using(new AddressValidator());
    }

    private boolean customerExists(int id) {
        return id == 1;
    }
}




































