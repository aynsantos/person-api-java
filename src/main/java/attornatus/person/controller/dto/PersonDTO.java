package attornatus.person.controller.dto;

import attornatus.person.model.Address;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDate;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonDTO {
    private String id;
    private String name;
    private LocalDate birthDate;
    private Address address;

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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
