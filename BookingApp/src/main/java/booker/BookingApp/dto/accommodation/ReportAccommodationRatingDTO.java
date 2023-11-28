package booker.BookingApp.dto.accommodation;

import booker.BookingApp.model.accommodation.AccommodationRating;
import lombok.Data;

public @Data class ReportAccommodationRatingDTO {
    public Long id;
    public boolean reported;

    public ReportAccommodationRatingDTO() {
    }

    public ReportAccommodationRatingDTO(AccommodationRating accommodationRating) {
        this(accommodationRating.getId(), accommodationRating.isReported());
    }

    public ReportAccommodationRatingDTO(Long id, boolean reported) {
        this.id = id;
        this.reported = reported;
    }
}
