package booker.BookingApp.model.accommodation;

import lombok.Data;

import java.util.Date;

public @Data class AccommodationRating {
    private Long id;
    private Long accommodationId;
    private Long guestId;
    private float rate;
    private Date when;
    private boolean reported;
}
