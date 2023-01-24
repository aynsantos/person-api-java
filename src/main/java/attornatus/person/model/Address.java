package attornatus.person.model;


import attornatus.person.enums.AddressType;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;



@Entity
@Table(name = "address")
public class Address {


    @ManyToOne
    private Person person;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String street;
    private String zipCode;
    private String city;
    private AddressType type;

    public Address(String street, String zipCode, String city, AddressType type) {
        this.street = street;
        this.zipCode = zipCode;
        this.city = city;
        this.type = type;
    }

    public Address(){

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
