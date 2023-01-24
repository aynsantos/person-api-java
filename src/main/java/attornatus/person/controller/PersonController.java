package attornatus.person.controller;


import attornatus.person.controller.dto.AddressDTO;
import attornatus.person.controller.dto.PersonDTO;
import attornatus.person.controller.mapper.AddressMapper;
import attornatus.person.controller.mapper.PersonMapper;
import attornatus.person.model.Address;
import attornatus.person.model.Person;
import attornatus.person.model.exception.PersonNotFoundException;
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

    private final AddressMapper addressMapper;

    public PersonController(PersonService personService, PersonMapper personMapper, AddressMapper addressMapper) {
        this.personService = personService;
        this.personMapper = personMapper;
        this.addressMapper = addressMapper;
    }

    @GetMapping
    @ApiOperation("Find all persons")
    public ResponseEntity<List<PersonDTO>> findAll(){
        List<Person> personList = personService.findAll();
        List<PersonDTO> result = personMapper.toPersonDTOList(personList);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    @ApiOperation("Find person")
    public ResponseEntity<PersonDTO> findById(@PathVariable String id){
        Person person = personService.findById(id);
        PersonDTO result = personMapper.toPersonDTO(person);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    @ApiOperation("Create person")
    public ResponseEntity<PersonDTO> create(@RequestBody PersonDTO dto) {
        Person personCreate = personMapper.toPerson(dto);
        Person person = personService.create(personCreate);
        PersonDTO result = personMapper.toPersonDTO(person);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete person")
    public ResponseEntity delete(@PathVariable String id){
      personService.delete(id);
        return ResponseEntity.noContent().build();
    }


    @PutMapping("/{id}")
    @ApiOperation("Update person")
    public ResponseEntity<PersonDTO> update(@PathVariable String id, @RequestBody PersonDTO dto) {
        Person personCreate = personMapper.toPerson(dto);
        Person person = personService.update(id, personCreate);
        PersonDTO result = personMapper.toPersonDTO(person);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PatchMapping("/{id}")
    @ApiOperation("Create address for a person")
    public ResponseEntity<PersonDTO> updateAddress(@PathVariable String id, @RequestBody AddressDTO addressDTO){
        Address addressCreate = addressMapper.toAddress(addressDTO);
        Person address = personService.addNewAddress(id, addressCreate);
        PersonDTO result = personMapper.toPersonDTO(address);
        return ResponseEntity.status(HttpStatus.OK).body(result);

    }














}
