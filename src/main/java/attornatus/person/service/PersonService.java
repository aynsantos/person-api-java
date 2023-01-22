package attornatus.person.service;

import attornatus.person.model.Address;
import attornatus.person.model.Person;
import org.springframework.stereotype.Service;


import java.util.*;
import java.util.stream.Collectors;


@Service
public class PersonService {




    private static Map<String, Person> personMap = new HashMap<>();

    static {
        var id = getUUID();
        var id2 = getUUID();
        Person person = new Person (id,"Zoro","12/12/1989",new Address("test", "test", "test"));
        Person person2 = new Person (id2,"Luffy","11/11/1998",new Address("test2", "test2", "test2"));
        personMap.put(id, person);
        personMap.put(id2, person2);
    }

    public List<Person> findAll(){
        return personMap.values().stream().collect(Collectors.toList());
    }

    private static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public Person findById(String id) {
        return personMap.get(id);
    }

    public Person create(Person personCreate) {
        String uuid = getUUID();
        personCreate.setId(uuid);
        personMap.put(uuid, personCreate);
        return personCreate;

    }
}
