package booker.BookingApp.model;

import lombok.Data;

import java.util.Date;

public @Data class OwnerRating {
    private Long id;
    private Long ownerId;
    private Long guestId;
    private float rate;
    private Date when;
    private boolean reported;
}
