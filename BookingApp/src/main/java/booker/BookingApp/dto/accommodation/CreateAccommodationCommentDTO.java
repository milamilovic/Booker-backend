package booker.BookingApp.dto.accommodation;

import booker.BookingApp.model.accommodation.AccommodationComment;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

public @Data class CreateAccommodationCommentDTO {
    @NotNull
    private Long accommodationId;
    @NotNull
    private Long guestId;
    @NotEmpty
    private String content;
    @Min(1) @Max(5)
    private double rating;
    //private Date date;

    public CreateAccommodationCommentDTO() {
    }

    public CreateAccommodationCommentDTO(AccommodationComment accommodationComment) {
        this(accommodationComment.getAccommodation().getId(), accommodationComment.getUser().getId(), accommodationComment.getContent(), accommodationComment.getRating());
    }

    public CreateAccommodationCommentDTO(Long accommodationId, Long guestId, String content, double rating) {
        this.accommodationId = accommodationId;
        this.guestId = guestId;
        this.content = content;
        this.rating = rating;
    }
}
