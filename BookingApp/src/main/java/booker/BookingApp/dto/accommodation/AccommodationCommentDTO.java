package booker.BookingApp.dto.accommodation;

import booker.BookingApp.model.accommodation.AccommodationComment;
import lombok.Data;

import java.util.Date;

public @Data class AccommodationCommentDTO {
    private Long id;
    //private Long accommodationId;
    //private Long guestId;
    private String content;
    private Date date;
    private boolean reported;

    public AccommodationCommentDTO() {
    }

    public AccommodationCommentDTO(AccommodationComment accommodationComment) {
        this(accommodationComment.getId(), accommodationComment.getContent(), accommodationComment.getDate(), accommodationComment.isReported());
    }

    public AccommodationCommentDTO(Long id, String content, Date date, boolean reported) {
        this.id = id;
        this.content = content;
        this.date = date;
        this.reported = reported;
    }
}
