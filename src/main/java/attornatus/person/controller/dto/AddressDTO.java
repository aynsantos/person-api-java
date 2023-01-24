package attornatus.person.controller.dto;

import attornatus.person.enums.AddressType;

public class AddressDTO {



    private long id;
    private String street;
    private String zipCode;
    private String city;
    private AddressType type;

    public AddressDTO(long id, String street, String zipCode, String city, AddressType type) {
        this.id = id;
        this.street = street;
        this.zipCode = zipCode;
        this.city = city;
        this.type = type;
    }

    public AddressDTO(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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
