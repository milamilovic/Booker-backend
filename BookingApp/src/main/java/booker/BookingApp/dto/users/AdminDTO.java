package booker.BookingApp.dto.users;

import booker.BookingApp.enums.Role;
import booker.BookingApp.model.users.Admin;
import booker.BookingApp.model.users.ProfilePicture;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class AdminDTO extends UserDTO {

    public AdminDTO(Long id, String name, String surname, String email, String password, String address, String phone, Role role, ProfilePicture profilePicture){
        super(id, name, surname, email, password, address, phone, role, profilePicture);
    }

    public static AdminDTO makeFromAdmin(Admin a){
        return new AdminDTO(a.getId(), a.getName(), a.getSurname(), a.getEmail(), a.getPassword(),
                a.getAddress(), a.getPhone(), a.getRole(), a.getProfilePicture());
    }
}
