package booker.BookingApp.dto.commentsAndRatings;

import booker.BookingApp.model.commentsAndRatings.OwnerComment;
import lombok.Data;

import java.util.Date;

public @Data class CreateOwnerCommentDTO {
    private Long ownerId;
    private Long guestId;
    private String content;
    private double rating;
//    private Date date;

    public CreateOwnerCommentDTO() {
    }

    public CreateOwnerCommentDTO(OwnerComment ownerComment) {
        this(ownerComment.getOwner().getId(), ownerComment.getGuest().getId(), ownerComment.getContent(), ownerComment.getRating());
    }

    public CreateOwnerCommentDTO(Long ownerId, Long guestId, String content, double rating) {
        this.ownerId = ownerId;
        this.guestId = guestId;
        this.content = content;
        this.rating = rating;
    }
}
