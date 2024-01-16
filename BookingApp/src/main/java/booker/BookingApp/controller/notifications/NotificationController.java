package booker.BookingApp.controller.notifications;

import booker.BookingApp.dto.notifications.NotificationDTO;
import booker.BookingApp.service.implementation.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/notifications")
@CrossOrigin(origins = "http://localhost:4200")
public class NotificationController {
    @Autowired
    NotificationService notificationService;


    @GetMapping(value = "/{userId}")
    public ResponseEntity<ArrayList<NotificationDTO>> findAllPersonal(@PathVariable Long userId){
        ArrayList<NotificationDTO> personalNotifications = notificationService.findAllForUser(userId);
        return new ResponseEntity<>(personalNotifications, HttpStatus.OK);
    }
}
