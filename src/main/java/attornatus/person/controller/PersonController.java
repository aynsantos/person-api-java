package attornatus.person.controller;


import attornatus.person.model.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {


    @GetMapping
    public List<Person> findAll(){
        Person person = new Person();
        person.setName("Allyson dos Santos");



        return Arrays.asList(person);

    }


}
