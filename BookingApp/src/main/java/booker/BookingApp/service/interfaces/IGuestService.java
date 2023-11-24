package booker.BookingApp.service.interfaces;

import booker.BookingApp.model.users.Guest;

public interface IGuestService {
    void findAll();
    void getGuestById(Long guestId);
    Guest create(Guest guest);
    Guest update(Guest guest);


    void delete(Long guestId);
}
