package attornatus.person.model;





import javax.persistence.*;

import java.util.ArrayList;

import java.util.List;


@Entity
@Table(name = "person")
public class Person{

    @Id
    private String id;
    private String name;
    private String birthDate;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "person_id")
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
