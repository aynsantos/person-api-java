package attornatus.person.controller.dto;

import attornatus.person.enums.AddressType;

public class AddressDTO {

    private PersonDTO personDTO;
    private String street;
    private String zipCode;
    private String city;
    private AddressType type;


    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public AddressType getType() {
        return type;
    }

    public void setType(AddressType type) {
        this.type = type;
    }
}
