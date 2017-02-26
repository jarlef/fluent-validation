package samples.domain;

@SuppressWarnings("all")
public class Customer {

    private Integer customerId;
    private String name;
    private Address address;

    public Customer(Integer customerId, String name, Address address) {
        this.customerId = customerId;
        this.name = name;
        this.address = address;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
