package booker.BookingApp.dto.users;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class GuestDTO extends UserDTO{

    public GuestDTO(String name, String surname, String email){
        super(name, surname, email);
    }
}
