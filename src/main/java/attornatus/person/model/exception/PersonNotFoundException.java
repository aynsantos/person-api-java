package attornatus.person.model.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class PersonNotFoundException extends RuntimeException {


    public PersonNotFoundException(String id) {
        super("Person not found with Id: " + id);
    }
}
