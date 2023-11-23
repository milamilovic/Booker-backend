package booker.BookingApp.model.accommodation;

import lombok.Data;

import java.util.Date;

public @Data class AccommodationComment {
    private Long id;
    private Long accommodationId;
    private Long guestId;
    private String content;
    private Date when;
    private boolean reported;
}
