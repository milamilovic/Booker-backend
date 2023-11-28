package booker.BookingApp.model.notifications;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

public @Data @AllArgsConstructor @NoArgsConstructor class Notification {
    private Long userId;
    private Date time;
    private String content;
    private String title;
}
