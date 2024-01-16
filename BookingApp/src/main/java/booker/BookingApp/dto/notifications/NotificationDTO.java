package booker.BookingApp.dto.notifications;

import booker.BookingApp.enums.NotificationType;
import booker.BookingApp.model.notifications.Notification;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

public @Data @AllArgsConstructor @NoArgsConstructor class NotificationDTO {
    private Long id;
    private Long userId;
    private String time;
    private String content;
    private NotificationType type;

    public static NotificationDTO makeFromNotification(Notification notification){
        NotificationDTO notificationDTO = new NotificationDTO();
        notificationDTO.id = notification.getId();
        notificationDTO.userId = notification.getUserId();
        notificationDTO.time = notification.getTime();
        notificationDTO.content = notification.getContent();
        notificationDTO.type = notification.getType();
        return notificationDTO;
    }

}
