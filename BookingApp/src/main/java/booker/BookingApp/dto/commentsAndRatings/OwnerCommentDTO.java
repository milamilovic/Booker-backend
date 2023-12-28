package booker.BookingApp.dto.commentsAndRatings;

import booker.BookingApp.model.commentsAndRatings.OwnerComment;
import lombok.Data;

import java.util.Date;

public @Data class OwnerCommentDTO {
    private Long id;
    private Long ownerId;
    private Long guestId;
    private String content;
    private Date date;
    private boolean reported;
    private boolean deleted;

    public OwnerCommentDTO() {
    }

    public OwnerCommentDTO(OwnerComment ownerComment) {
        this(ownerComment.getId(), ownerComment.getOwner().getId(), ownerComment.getGuest().getId(), ownerComment.getContent(), ownerComment.getDate(), ownerComment.isReported(), ownerComment.isDeleted());
    }

    public OwnerCommentDTO(Long id, Long ownerId, Long guestId, String content, Date date, boolean reported, boolean deleted) {
        this.id = id;
        this.ownerId = ownerId;
        this.guestId = guestId;
        this.content = content;
        this.date = date;
        this.reported = reported;
        this.deleted = deleted;
    }

    public static OwnerCommentDTO createFromOwnerComment(OwnerComment ownerComment) {
        return new OwnerCommentDTO(ownerComment.getId(),
                ownerComment.getOwner().getId(),
                ownerComment.getGuest().getId(),
                ownerComment.getContent(),
                ownerComment.getDate(),
                ownerComment.isReported(),
                ownerComment.isDeleted());
    }
}
