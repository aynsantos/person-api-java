package attornatus.person.model;


import com.fasterxml.jackson.annotation.JsonFormat;


import java.util.ArrayList;

import java.util.List;

public class Person {

    private String id;
    private String name;
    //@JsonFormat(pattern = "dd/MM/yyyy")
    private String birthDate;
    private List<Address> addresses = new ArrayList<>();

    public Person(String id, String name, String birthDate, List<Address> addresses) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.addresses = addresses;
    }

    public Person(){

    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public void addNewAddresses(Address addresses) {
        this.addresses.add(addresses);
    }


}
