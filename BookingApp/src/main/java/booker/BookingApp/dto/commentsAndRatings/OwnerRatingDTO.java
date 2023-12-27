package booker.BookingApp.dto.commentsAndRatings;

import booker.BookingApp.model.commentsAndRatings.OwnerRating;
import lombok.Data;

import java.util.Date;

public @Data class OwnerRatingDTO {
    private Long id;
    private Long ownerId;
    private Long guestId;
    private float rate;
    private Date date;
    private boolean reported;
    private boolean deleted;

    public OwnerRatingDTO() {
    }

    public OwnerRatingDTO(OwnerRating ownerRating) {
        this(ownerRating.getId(), ownerRating.getOwner().getId(), ownerRating.getGuest().getId(), ownerRating.getRate(), ownerRating.getDate(), ownerRating.isReported(), ownerRating.isDeleted());
    }

    public OwnerRatingDTO(Long id, Long ownerId, Long guestId, float rate, Date date, boolean reported, boolean deleted) {
        this.id = id;
        this.ownerId = ownerId;
        this.guestId = guestId;
        this.rate = rate;
        this.date = date;
        this.reported = reported;
        this.deleted = deleted;
    }

    public static OwnerRatingDTO makeFromOwnerRating(OwnerRating ownerRating) {
        return new OwnerRatingDTO(ownerRating.getId(),
                ownerRating.getOwner().getId(),
                ownerRating.getGuest().getId(),
                ownerRating.getRate(),
                ownerRating.getDate(),
                ownerRating.isReported(),
                ownerRating.isDeleted());
    }
}
