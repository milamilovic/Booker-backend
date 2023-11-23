package booker.BookingApp.dto.accommodation;

import booker.BookingApp.model.accommodation.AccommodationRating;
import lombok.Data;

import java.util.Date;

public @Data class AccommodationRatingDTO {
    private Long id;
    private Long accommodationId;
    private Long guestId;
    private float rate;
    private Date when;
    private boolean reported;

    public AccommodationRatingDTO() {
    }

    public AccommodationRatingDTO(AccommodationRating accommodationRating) {
        this(accommodationRating.getId(), accommodationRating.getAccommodationId(), accommodationRating.getGuestId(), accommodationRating.getRate(), accommodationRating.getWhen(), accommodationRating.isReported());
    }

    public AccommodationRatingDTO(Long id, Long accommodationId, Long guestId, float rate, Date when, boolean reported) {
        this.id = id;
        this.accommodationId = accommodationId;
        this.guestId = guestId;
        this.rate = rate;
        this.when = when;
        this.reported = reported;
    }
}
