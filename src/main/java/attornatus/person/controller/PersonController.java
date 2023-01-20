package attornatus.person.controller;


import attornatus.person.controller.dto.PersonDTO;
import attornatus.person.controller.mapper.PersonMapper;
import attornatus.person.model.Person;
import attornatus.person.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {


    private final PersonService personService;
    private final PersonMapper personMapper;

    public PersonController(PersonService personService, PersonMapper personMapper) {
        this.personService = personService;
        this.personMapper = personMapper;
    }

    @GetMapping
    public List<PersonDTO> findAll(){
        List<Person> personList = personService.findAll();
        List<PersonDTO> result = personMapper.toPersonDTOList(personList);
        return result;
    }


}
