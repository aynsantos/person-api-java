package attornatus.person.service;

import attornatus.person.model.Address;
import attornatus.person.model.exception.PersonNotFoundException;
import attornatus.person.model.Person;
import attornatus.person.repository.AddressRepository;
import attornatus.person.repository.PersonRepository;
import org.springframework.stereotype.Service;


import java.util.*;



@Service
public class PersonService {

    private final PersonRepository personRepository;
    private final AddressRepository addressRepository;



    public PersonService(PersonRepository personRepository, AddressRepository addressRepository) {
        this.personRepository = personRepository;
        this.addressRepository = addressRepository;
    }


    public List<Person> findAll(){
        return personRepository.findAll();
    }

    private static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public Person findById(String id) {
        return personRepository.findById(id).orElseThrow(() ->
                new PersonNotFoundException(id));
    }

    public Person create(Person personCreate) {
        String uuid = getUUID();
        personCreate.setId(uuid);
        personRepository.save(personCreate);
        return personCreate;

    }

    public void delete(String id) {
        findById(id);
        personRepository.deleteById(id);

    }

    public Person update(String id, Person personCreate) {
        Person person = findById(id);
        person.setName(personCreate.getName());
        person.setBirthDate(personCreate.getBirthDate());
        person.setAddresses(personCreate.getAddresses());
        personRepository.save(person);
        return person;
    }


    public Person addNewAddress(String id, Address createAddress){
        Person person = findById(id);
        person.addNewAddresses(createAddress);
        personRepository.save(person);
        return person;

    }



}
