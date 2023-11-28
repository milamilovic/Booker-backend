package booker.BookingApp.dto.users;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class OwnerDTO extends UserDTO {

    public OwnerDTO(String name, String surname, String email){
        super(name, surname, email);
    }
}
