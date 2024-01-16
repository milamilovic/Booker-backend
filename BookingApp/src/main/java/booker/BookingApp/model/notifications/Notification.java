package booker.BookingApp.model.notifications;

import booker.BookingApp.enums.NotificationType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
public @Data @AllArgsConstructor @NoArgsConstructor class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_id", nullable = false)
    private Long userId;
    @Column(name = "time", nullable = false)
    private String time;
    @Column(name = "content", nullable = false)
    private String content;
    @Column(name = "type", nullable = false)
    private NotificationType type;
}
