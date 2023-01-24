package attornatus.person.repository;

import attornatus.person.model.Address;

import attornatus.person.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {

    List<Address> findByPerson(Person person);


}