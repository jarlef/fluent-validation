package samples.domain;

@SuppressWarnings("all")
public class Address {
    private String streetAddress;
    private String zipCode;
    private String city;

    public Address(String streetAddress, String zipCode, String city) {
        this.streetAddress = streetAddress;
        this.zipCode = zipCode;
        this.city = city;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
