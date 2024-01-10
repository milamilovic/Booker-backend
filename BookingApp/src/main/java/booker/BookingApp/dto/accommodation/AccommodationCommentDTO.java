package booker.BookingApp.dto.accommodation;

import booker.BookingApp.model.accommodation.AccommodationComment;
import lombok.Data;

import java.util.Date;

public @Data class AccommodationCommentDTO {
    private Long id;
    private Long accommodationId;
    private Long guestId;
    private String content;
    private double rating;
    private Date date;
    private boolean reported;
    private boolean deleted;

    public AccommodationCommentDTO() {
    }

    public AccommodationCommentDTO(AccommodationComment accommodationComment) {
        this(accommodationComment.getId(), accommodationComment.getAccommodation().getId(), accommodationComment.getUser().getId(), accommodationComment.getContent(), accommodationComment.getRating(), accommodationComment.getDate(), accommodationComment.isReported(), accommodationComment.isDeleted());
    }

    public AccommodationCommentDTO(Long id, Long accommodationId, Long guestId, String content, double rating, Date date, boolean reported, boolean deleted) {
        this.id = id;
        this.accommodationId = accommodationId;
        this.guestId = guestId;
        this.content = content;
        this.rating = rating;
        this.date = date;
        this.reported = reported;
        this.deleted = deleted;
    }

    public static AccommodationCommentDTO createFromAccommodationComment(AccommodationComment accommodationComment) {
        return new AccommodationCommentDTO(accommodationComment.getId(),
                                            accommodationComment.getAccommodation().getId(),
                                            accommodationComment.getUser().getId(),
                                            accommodationComment.getContent(),
                                            accommodationComment.getRating(),
                                            accommodationComment.getDate(),
                                            accommodationComment.isReported(),
                                            accommodationComment.isDeleted());
    }
}
