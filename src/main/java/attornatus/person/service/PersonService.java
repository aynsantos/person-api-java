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
        Person person = new Person (id,"Zoro",null,new Address("test", "test", "test"));
        personMap.put(id, person);
    }

    public List<Person> findAll(){
        return personMap.values().stream().collect(Collectors.toList());
    }

    private static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

}
