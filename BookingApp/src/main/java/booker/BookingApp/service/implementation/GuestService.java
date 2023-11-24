package booker.BookingApp.service.implementation;

import booker.BookingApp.model.users.Guest;
import booker.BookingApp.service.interfaces.IGuestService;

public class GuestService implements IGuestService {
    @Override
    public void findAll() {
    }
    @Override
    public void getGuestById(Long id) {
    }

    @Override
    public Guest create(Guest guest) {
        return guest;
    }

    @Override
    public Guest update(Guest guest) {
        return guest;
    }

    @Override
    public void delete(Long id) {
    }
}
