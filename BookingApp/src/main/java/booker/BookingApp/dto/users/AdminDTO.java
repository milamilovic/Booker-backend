package booker.BookingApp.dto.users;

import booker.BookingApp.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class AdminDTO extends UserDTO {

    public AdminDTO(Long id, String name, String surname, String email, String address, String phone, Role role){
        super(id, name, surname, email, address, phone, role);
    }
}
