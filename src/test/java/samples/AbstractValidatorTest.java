package samples;

import com.github.jarlef.fluentvalidation.ValidationResult;
import org.junit.Before;
import org.junit.Test;
import samples.domain.Address;
import samples.domain.Customer;
import samples.domain.CustomerValidator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AbstractValidatorTest {

    private Address address;
    private Customer customer;
    private CustomerValidator validator;

    @Before
    public void setup() {
        address = new Address("Some street", "1234", "London");
        customer = new Customer(1, "John", address);
        validator = new CustomerValidator();
    }
    @Test
    public void test_valid_customer() {

        ValidationResult result = validator.validate(customer);

        assertTrue(result.isValid());
        assertTrue(result.getErrors().length == 0);
    }

    @Test
    public void test_no_customer_id() {

        customer.setCustomerId(0);

        ValidationResult result = validator.validate(customer);

        assertFalse(result.isValid());
        assertTrue(result.getErrors().length == 1);
        assertEquals("customer id", result.getErrors()[0].getPropertyName());
        assertEquals("customer id cannot be empty", result.getErrors()[0].getMessage());
    }

    @Test
    public void test_no_name() {

        customer.setName(null);

        ValidationResult result = validator.validate(customer);

        assertFalse(result.isValid());
        assertTrue(result.getErrors().length == 1);

        assertEquals("name", result.getErrors()[0].getPropertyName());
        assertEquals("name cannot be empty", result.getErrors()[0].getMessage());
    }

    @Test
    public void test_invalid_name() {

        customer.setName("Scott");

        ValidationResult result = validator.validate(customer);

        assertFalse(result.isValid());
        assertTrue(result.getErrors().length == 1);
        assertEquals("name", result.getErrors()[0].getPropertyName());
        assertEquals("Hey Scott. You are not John", result.getErrors()[0].getMessage());
    }


    @Test
    public void test_no_address() {

        customer.setAddress(null);

        ValidationResult result = validator.validate(customer);

        assertFalse(result.isValid());
        assertTrue(result.getErrors().length == 1);
        assertEquals("getAddress", result.getErrors()[0].getPropertyName());
    }


    @Test
    public void test_no_city() {

        address.setCity(null);

        ValidationResult result = validator.validate(customer);

        assertFalse(result.isValid());
        assertTrue(result.getErrors().length == 1);
    }
}
