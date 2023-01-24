package attornatus.person.controller.mapper;

import attornatus.person.controller.dto.AddressDTO;
import attornatus.person.model.Address;
import attornatus.person.model.Person;
import attornatus.person.repository.AddressRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class AddressMapper {

    private final AddressRepository addressRepository;

    public AddressMapper(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    private static final ModelMapper MODEL_MAPPER = new ModelMapper();



    public AddressDTO toAddressDTO(Address address){
        return MODEL_MAPPER.map(address, AddressDTO.class);
    }

    public List<Address> findAddressByPerson(Person person){
        return addressRepository.findByPerson(person);
    }

    public Address toAddress(AddressDTO dto) {
        return MODEL_MAPPER.map(dto, Address.class);
    }
}
