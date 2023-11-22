package booker.BookingApp.service.interfaces;

import booker.BookingApp.model.Guest;

import java.util.ArrayList;

public interface IGuestService {
    void findAll();
    void getGuestById(Long guestId);
    Guest create(Guest guest);
    Guest update(Guest guest);


    void delete(Long guestId);
}
