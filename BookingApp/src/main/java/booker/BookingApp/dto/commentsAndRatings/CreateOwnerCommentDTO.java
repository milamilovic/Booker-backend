package booker.BookingApp.dto.commentsAndRatings;

import booker.BookingApp.model.commentsAndRatings.OwnerComment;
import lombok.Data;

import java.util.Date;

public @Data class CreateOwnerCommentDTO {
    private Long ownerId;
    private Long guestId;
    private String content;
    private Date date;

    public CreateOwnerCommentDTO() {
    }

    public CreateOwnerCommentDTO(OwnerComment ownerComment) {
        this(ownerComment.getOwner().getId(), ownerComment.getGuest().getId(), ownerComment.getContent(), ownerComment.getDate());
    }

    public CreateOwnerCommentDTO(Long ownerId, Long guestId, String content, Date date) {
        this.ownerId = ownerId;
        this.guestId = guestId;
        this.content = content;
        this.date = date;
    }
}
