package booker.BookingApp.dto.users;

import booker.BookingApp.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class GuestDTO extends UserDTO{
    private boolean blocked;
    private boolean deleted;
    private ArrayList<Long> favouriteAccommodations;

    public GuestDTO(Long id, String name, String surname, String email, String address, String phone,
                    Role role, boolean blocked, boolean deleted, ArrayList<Long> favouriteAccommodations){
        super(id, name, surname, email, address, phone, role);
        this.blocked = blocked;
        this.deleted = deleted;
        this.favouriteAccommodations = favouriteAccommodations;
    }
}
