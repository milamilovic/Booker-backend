package booker.BookingApp.dto;

import booker.BookingApp.model.OwnerComment;
import lombok.Data;

import java.util.Date;

public @Data class OwnerCommentDTO {
    private Long id;
    private Long ownerId;
    private Long guestId;
    private String content;
    private Date when;
    private boolean reported;

    public OwnerCommentDTO() {
    }

    public OwnerCommentDTO(OwnerComment ownerComment) {
        this(ownerComment.getId(), ownerComment.getOwnerId(), ownerComment.getGuestId(), ownerComment.getContent(), ownerComment.getWhen(), ownerComment.isReported());
    }

    public OwnerCommentDTO(Long id, Long ownerId, Long guestId, String content, Date when, boolean reported) {
        this.id = id;
        this.ownerId = ownerId;
        this.guestId = guestId;
        this.content = content;
        this.when = when;
        this.reported = reported;
    }
}
