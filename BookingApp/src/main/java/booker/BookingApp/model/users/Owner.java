package booker.BookingApp.model.users;

import booker.BookingApp.model.commentsAndRatings.OwnerComment;
import booker.BookingApp.model.commentsAndRatings.OwnerRating;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;

@EqualsAndHashCode(callSuper = true)
@Data
public class Owner extends User {
    private boolean reported;
    private boolean blocked;
    private boolean deleted;
    private ArrayList<OwnerRating> ratings;
    private ArrayList<OwnerComment> comments;
}
