package booker.BookingApp.dto.accommodation;

import booker.BookingApp.model.accommodation.AccommodationComment;

public class ReportAccommodationCommentDTO {
    private Long id;
    private boolean reported;

    public ReportAccommodationCommentDTO() {
    }

    public ReportAccommodationCommentDTO(AccommodationComment accommodationComment) {
        this(accommodationComment.getId(), accommodationComment.isReported());
    }

    public ReportAccommodationCommentDTO(Long id, boolean reported) {
        this.id = id;
        this.reported = reported;
    }
}
