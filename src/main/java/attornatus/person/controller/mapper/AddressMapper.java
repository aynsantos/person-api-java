package attornatus.person.controller.mapper;

import attornatus.person.controller.dto.AddressDTO;
import attornatus.person.model.Address;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class AddressMapper {

    private static final ModelMapper MODEL_MAPPER = new ModelMapper();

    public AddressDTO toAddressDTO(Address address){
        return MODEL_MAPPER.map(address, AddressDTO.class);
    }

    public List<AddressDTO> toAddressDTOList(List<Address> addressListList) {
        return addressListList.stream().map(this::toAddressDTO).collect(Collectors.toList());
    }

    public Address toAddress(AddressDTO dto) {
        return MODEL_MAPPER.map(dto, Address.class);
    }
}
