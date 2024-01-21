package booker.BookingApp.dto.commentsAndRatings;

import booker.BookingApp.model.commentsAndRatings.OwnerRating;
import booker.BookingApp.model.users.Owner;
import lombok.Data;

import java.util.Date;

public @Data class CreateOwnerRatingDTO {
    private Long ownerId;
    private Long guestId;
    private float rate;
//    private Date date;

    public CreateOwnerRatingDTO() {
    }

    public CreateOwnerRatingDTO(OwnerRating ownerRating) {
        this(ownerRating.getOwner().getId(), ownerRating.getGuest().getId(), ownerRating.getRate());
    }

    public CreateOwnerRatingDTO(Long ownerId, Long guestId, float rate) {
        this.ownerId = ownerId;
        this.guestId = guestId;
        this.rate = rate;
    }
}
