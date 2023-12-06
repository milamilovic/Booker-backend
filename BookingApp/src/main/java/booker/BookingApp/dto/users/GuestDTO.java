package booker.BookingApp.dto.users;

import booker.BookingApp.enums.Role;
import booker.BookingApp.model.users.ProfilePicture;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class GuestDTO extends UserDTO{
    private boolean reported;
    private boolean blocked;
    private boolean deleted;
    private ArrayList<Long> favouriteAccommodations;

    public GuestDTO(Long id, String name, String surname, String email, String address, String phone,
                    Role role, ProfilePicture profilePicture, boolean reported, boolean blocked,
                    boolean deleted, ArrayList<Long> favouriteAccommodations){
        super(id, name, surname, email, address, phone, role, profilePicture);
        this.reported = reported;
        this.blocked = blocked;
        this.deleted = deleted;
        this.favouriteAccommodations = favouriteAccommodations;
    }
}
