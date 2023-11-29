package booker.BookingApp.dto.users;

import booker.BookingApp.enums.Role;
import booker.BookingApp.model.commentsAndRatings.OwnerComment;
import booker.BookingApp.model.commentsAndRatings.OwnerRating;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class OwnerDTO extends UserDTO {
    private ArrayList<OwnerRating> ratings;
    private ArrayList<OwnerComment> comments;

    public OwnerDTO(Long id, String name, String surname, String email, String address,
                    String phone, Role role, ArrayList<OwnerRating> ratings, ArrayList<OwnerComment> comments){
        super(id, name, surname, email, address, phone, role);
        this.ratings = ratings;
        this.comments = comments;
    }
}
