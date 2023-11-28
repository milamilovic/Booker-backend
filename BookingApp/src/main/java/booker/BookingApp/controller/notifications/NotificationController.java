package booker.BookingApp.controller.notifications;

import booker.BookingApp.dto.notifications.NotificationDTO;
import booker.BookingApp.service.implementation.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {
    @Autowired
    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping(value = "/all")
    public ResponseEntity<ArrayList<NotificationDTO>> getAll(){
        ArrayList<NotificationDTO> notifications = notificationService.getAll();
        return new ResponseEntity<>(notifications, HttpStatus.OK);
    }

    @GetMapping(value = "/{userId}")
    public ResponseEntity<ArrayList<NotificationDTO>> findAllPersonal(@PathVariable Long userId){
        ArrayList<NotificationDTO> personalNotifications = notificationService.findAllForUser(userId);
        return new ResponseEntity<>(personalNotifications, HttpStatus.OK);
    }
}
