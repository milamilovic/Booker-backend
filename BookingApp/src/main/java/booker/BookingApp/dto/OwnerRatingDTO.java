package booker.BookingApp.dto;

import booker.BookingApp.model.OwnerRating;
import lombok.Data;

import java.util.Date;

public @Data class OwnerRatingDTO {
    private Long id;
    //private Long ownerId;
    //private Long guestId;
    private float rate;
    private Date date;
    private boolean reported;

    public OwnerRatingDTO() {
    }

    public OwnerRatingDTO(OwnerRating ownerRating) {
        this(ownerRating.getId(), ownerRating.getRate(), ownerRating.getDate(), ownerRating.isReported());
    }

    public OwnerRatingDTO(Long id, float rate, Date date, boolean reported) {
        this.id = id;
        this.rate = rate;
        this.date = date;
        this.reported = reported;
    }
}
