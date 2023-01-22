package attornatus.person.controller;


import attornatus.person.controller.dto.PersonDTO;
import attornatus.person.controller.mapper.PersonMapper;
import attornatus.person.model.Person;
import attornatus.person.service.PersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/person")
@Api(tags = "Person Controller")
public class PersonController {


    private final PersonService personService;
    private final PersonMapper personMapper;

    public PersonController(PersonService personService, PersonMapper personMapper) {
        this.personService = personService;
        this.personMapper = personMapper;
    }

    @GetMapping
    @ApiOperation("Find all persons")
    public ResponseEntity<List<PersonDTO>> findAll(){
        List<Person> personList = personService.findAll();
        List<PersonDTO> result = personMapper.toPersonDTOList(personList);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDTO> findById(@PathVariable String id){
        Person person = personService.findById(id);
        PersonDTO result = personMapper.toPersonDTO(person);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<PersonDTO> create(@RequestBody PersonDTO dto) {
        Person personCreate = personMapper.toPerson(dto);
        Person person = personService.create(personCreate);
        PersonDTO result = personMapper.toPersonDTO(person);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);

    }


}
