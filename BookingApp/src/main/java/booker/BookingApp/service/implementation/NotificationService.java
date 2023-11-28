package booker.BookingApp.service.implementation;

import booker.BookingApp.dto.notifications.NotificationDTO;
import booker.BookingApp.dto.users.UserDTO;
import booker.BookingApp.service.interfaces.INotificationService;

import java.util.ArrayList;
import java.util.Objects;

public class NotificationService implements INotificationService {
    @Override
    public ArrayList<NotificationDTO> getAll() {
        ArrayList<NotificationDTO> notifications = new ArrayList<>();
        NotificationDTO n1 = new NotificationDTO(1L, "Someone rated you.");
        NotificationDTO n2 = new NotificationDTO(1L, "Someone rated your accommodation.");
        NotificationDTO n3 = new NotificationDTO(2L, "Someone rated you.");
        notifications.add(n1);
        notifications.add(n2);
        notifications.add(n3);
        return notifications;
    }

    @Override
    public ArrayList<NotificationDTO> findAllForUser(Long userId) {
        ArrayList<NotificationDTO> notifications = getAll();
        ArrayList<NotificationDTO> personalNotifications = new ArrayList<>();
        // check userId for every notification
        for(NotificationDTO n : notifications){
            if(Objects.equals(n.getUserId(), userId)){
                personalNotifications.add(n);
            }
        }
        return personalNotifications;
    }
}
