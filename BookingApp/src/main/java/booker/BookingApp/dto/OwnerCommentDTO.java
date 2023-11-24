package booker.BookingApp.dto;

import booker.BookingApp.model.OwnerComment;
import lombok.Data;

import java.util.Date;

public @Data class OwnerCommentDTO {
    private Long id;
    //private Long ownerId;
    //private Long guestId;
    private String content;
    private Date date;
    private boolean reported;

    public OwnerCommentDTO() {
    }

    public OwnerCommentDTO(OwnerComment ownerComment) {
        this(ownerComment.getId(), ownerComment.getContent(), ownerComment.getDate(), ownerComment.isReported());
    }

    public OwnerCommentDTO(Long id, String content, Date date, boolean reported) {
        this.id = id;
        this.content = content;
        this.date = date;
        this.reported = reported;
    }
}
