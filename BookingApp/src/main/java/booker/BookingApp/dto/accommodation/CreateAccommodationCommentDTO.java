package booker.BookingApp.dto.accommodation;

import booker.BookingApp.model.accommodation.AccommodationComment;
import lombok.Data;

import java.util.Date;

public @Data class CreateAccommodationCommentDTO {
    private Long accommodationId;
    private Long guestId;
    private String content;
    private Date date;

    public CreateAccommodationCommentDTO() {
    }

    public CreateAccommodationCommentDTO(AccommodationComment accommodationComment) {
        this(accommodationComment.getAccommodation().getId(), accommodationComment.getUser().getId(), accommodationComment.getContent(), accommodationComment.getDate());
    }

    public CreateAccommodationCommentDTO(Long accommodationId, Long guestId, String content, Date date) {
        this.accommodationId = accommodationId;
        this.guestId = guestId;
        this.content = content;
        this.date = date;
    }
}
