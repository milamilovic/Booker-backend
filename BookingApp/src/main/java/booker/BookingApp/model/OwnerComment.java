package booker.BookingApp.model;

import lombok.Data;

import java.util.Date;

public @Data class OwnerComment {
    private Long id;
    private Long guestId;
    private Long ownerId;
    private String content;
    private Date when;
    private boolean reported;
}
