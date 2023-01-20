package attornatus.person.controller.mapper;

import attornatus.person.controller.dto.PersonDTO;
import attornatus.person.model.Person;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PersonMapper {

    private static final ModelMapper MODEL_MAPPER = new ModelMapper();

    public PersonDTO personDTO(Person person){
        return MODEL_MAPPER.map(person, PersonDTO.class);
    }

    public List<PersonDTO> toPersonDTOList(List<Person> personList) {
        return personList.stream().map(this::personDTO).collect(Collectors.toList());
    }
}
