package booker.BookingApp.model.notifications;

import lombok.Data;

import java.util.Date;

public @Data class Notification {
    private Date time;
    private String content;
    private String title;
}
