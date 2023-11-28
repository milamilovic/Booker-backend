package booker.BookingApp.dto.commentsAndRatings;

import booker.BookingApp.model.commentsAndRatings.OwnerComment;

public class ReportOwnerCommentDTO {
    private Long id;
    private boolean reported;

    public ReportOwnerCommentDTO() {
    }

    public ReportOwnerCommentDTO(OwnerComment ownerComment) {
        this(ownerComment.getId(), ownerComment.isReported());
    }

    public ReportOwnerCommentDTO(Long id, boolean reported) {
        this.id = id;
        this.reported = reported;
    }
}
