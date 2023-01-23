package attornatus.person.model;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Person {



    private String id;
    private String name;
    private Date birthDate;
    private List<Address> address;


    public Person(String id, String name, Date birthDate, List<Address> address) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.address = address;
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }






}
