package booker.BookingApp.service.implementation;

import booker.BookingApp.dto.notifications.NotificationDTO;
import booker.BookingApp.dto.users.UserDTO;
import booker.BookingApp.model.notifications.Notification;
import booker.BookingApp.repository.NotificationRepository;
import booker.BookingApp.service.interfaces.INotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class NotificationService implements INotificationService {

    @Autowired
    NotificationRepository repository;

    @Override
    public ArrayList<NotificationDTO> findAllForUser(Long userId) {
        List<Notification> notifications = repository.findAllPersonal(userId);
        ArrayList<NotificationDTO> personalNotifications = new ArrayList<>();
        // check userId for every notification
        for(Notification n : notifications){
            personalNotifications.add(NotificationDTO.makeFromNotification(n));
        }
        return personalNotifications;
    }
}
