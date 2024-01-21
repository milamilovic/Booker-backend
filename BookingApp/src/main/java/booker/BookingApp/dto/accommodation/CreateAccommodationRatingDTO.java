package booker.BookingApp.dto.accommodation;

import booker.BookingApp.model.accommodation.AccommodationRating;
import lombok.Data;

import java.util.Date;

public @Data class CreateAccommodationRatingDTO {
    private Long accommodationId;
    private Long guestId;
    private float rate;
    private Date date;

    public CreateAccommodationRatingDTO() {
    }

    public CreateAccommodationRatingDTO(AccommodationRating rating) {
        this(rating.getAccommodation().getId(), rating.getGuest().getId(), rating.getRate(), rating.getDate());
    }

    public CreateAccommodationRatingDTO(Long accommodationId, Long guestId, float rate, Date date) {
        this.accommodationId = accommodationId;
        this.guestId = guestId;
        this.rate = rate;
        this.date = date;
    }
}
