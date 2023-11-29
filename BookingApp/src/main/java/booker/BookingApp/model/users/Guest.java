package booker.BookingApp.model.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class Guest extends User {
    private boolean blocked;
    private boolean deleted;
    private ArrayList<Long> favouriteAccommodations;
}
