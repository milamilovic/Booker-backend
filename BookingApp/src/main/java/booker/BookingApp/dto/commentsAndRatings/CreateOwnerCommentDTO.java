package booker.BookingApp.dto.commentsAndRatings;

import booker.BookingApp.model.commentsAndRatings.OwnerComment;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

public @Data class CreateOwnerCommentDTO {
    @NotNull
    private Long ownerId;
    @NotNull
    private Long guestId;
    @NotEmpty
    private String content;
    @Min(1) @Max(5)
    private double rating;
//    private Date date;

    public CreateOwnerCommentDTO() {
    }

    public CreateOwnerCommentDTO(OwnerComment ownerComment) {
        this(ownerComment.getOwner().getId(), ownerComment.getGuest().getId(), ownerComment.getContent(), ownerComment.getRating());
    }

    public CreateOwnerCommentDTO(Long ownerId, Long guestId, String content, double rating) {
        this.ownerId = ownerId;
        this.guestId = guestId;
        this.content = content;
        this.rating = rating;
    }
}
