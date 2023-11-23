package booker.BookingApp.dto;

import booker.BookingApp.model.OwnerRating;
import lombok.Data;

import java.util.Date;

public @Data class OwnerRatingDTO {
    private Long id;
    private Long ownerId;
    private Long guestId;
    private float rate;
    private Date when;
    private boolean reported;

    public OwnerRatingDTO() {
    }

    public OwnerRatingDTO(OwnerRating ownerRating) {
        this(ownerRating.getId(), ownerRating.getOwnerId(), ownerRating.getGuestId(), ownerRating.getRate(), ownerRating.getWhen(), ownerRating.isReported());
    }

    public OwnerRatingDTO(Long id, Long ownerId, Long guestId, float rate, Date when, boolean reported) {
        this.id = id;
        this.ownerId = ownerId;
        this.guestId = guestId;
        this.rate = rate;
        this.when = when;
        this.reported = reported;
    }
}
