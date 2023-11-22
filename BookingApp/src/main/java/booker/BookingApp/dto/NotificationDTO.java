package booker.BookingApp.dto;

import booker.BookingApp.model.Notification;
import lombok.Data;

import java.util.Date;

public @Data class NotificationDTO {
    private Date time;
    private String content;
    private String title;

    public NotificationDTO makeFromNotification(Notification notification){
        NotificationDTO notificationDTO = new NotificationDTO();
        notificationDTO.time = notification.getTime();
        notificationDTO.content = notification.getContent();
        notificationDTO.title = notification.getTitle();
        return notificationDTO;
    }

}
