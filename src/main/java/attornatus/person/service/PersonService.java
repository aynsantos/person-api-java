package attornatus.person.service;

import attornatus.person.model.Address;
import attornatus.person.model.exception.PersonNotFoundException;
import attornatus.person.model.Person;
import attornatus.person.repository.PersonRepository;
import org.springframework.stereotype.Service;


import java.util.*;
import java.util.stream.Collectors;


@Service
public class PersonService {

    private final PersonRepository personRepository;



    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    public List<Person> findAll(){
        return personRepository.findAll();
        return personMap.values().stream().collect(Collectors.toList());
    }

    private static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public Person findById(String id) {
        Person person = personMap.get(id);
        if(person == null){
            throw new PersonNotFoundException(id);
        }
        return person;
    }

    public Person create(Person personCreate) {
        String uuid = getUUID();
        personCreate.setId(uuid);
        personMap.put(uuid, personCreate);
        return personCreate;

    }

    public void delete(String id) {
        findById(id);
        personMap.remove(id);

    }

    public Person update(String id, Person personCreate) {
        Person person = findById(id);
        person.setName(personCreate.getName());
        personMap.replace(id, person);
        return person;
    }


    public Person addNewAddress(String id, Address createAddress){
        Person person = findById(id);
        person.addNewAddresses(createAddress);
        return person;

    }



}
