package booker.BookingApp.dto.accommodation;

import booker.BookingApp.model.accommodation.AccommodationComment;
import lombok.Data;

import java.util.Date;

public @Data class AccommodationCommentDTO {
    private Long id;
    private Long accommodationId;
    private Long guestId;
    private String content;
    private Date when;
    private boolean reported;

    public AccommodationCommentDTO() {
    }

    public AccommodationCommentDTO(AccommodationComment accommodationComment) {
        this(accommodationComment.getId(), accommodationComment.getAccommodationId(), accommodationComment.getGuestId(), accommodationComment.getContent(), accommodationComment.getWhen(), accommodationComment.isReported());
    }

    public AccommodationCommentDTO(Long id, Long accommodationId, Long guestId, String content, Date when, boolean reported) {
        this.id = id;
        this.accommodationId = accommodationId;
        this.guestId = guestId;
        this.content = content;
        this.when = when;
        this.reported = reported;
    }
}
