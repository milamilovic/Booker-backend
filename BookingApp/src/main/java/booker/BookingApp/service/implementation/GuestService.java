package booker.BookingApp.service.implementation;

import booker.BookingApp.dto.users.GuestDTO;
import booker.BookingApp.model.users.Guest;
import booker.BookingApp.service.interfaces.IGuestService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
@Service
public class GuestService implements IGuestService {
    @Override
    public ArrayList<GuestDTO> findAll() {
        GuestDTO g1 = new GuestDTO("Pera", "Peric", "pera123@gmail.com");
        GuestDTO g2 = new GuestDTO("Pera", "Peric", "pera123@gmail.com");
        GuestDTO g3 = new GuestDTO("Pera", "Peric", "pera123@gmail.com");
        GuestDTO g4 = new GuestDTO("Pera", "Peric", "pera123@gmail.com");
        GuestDTO g5 = new GuestDTO("Pera", "Peric", "pera123@gmail.com");
        GuestDTO g6 = new GuestDTO("Pera", "Peric", "pera123@gmail.com");
        ArrayList<GuestDTO> guests = new ArrayList<>();
        guests.add(g1);
        guests.add(g2);
        guests.add(g3);
        guests.add(g4);
        guests.add(g5);
        guests.add(g6);
        return guests;
    }
    @Override
    public GuestDTO getGuestById(Long id) {
        return new GuestDTO("Pera", "Peric", "pera123@gmail.com");
    }

    @Override
    public GuestDTO getGuestByEmail(String email) {
        return new GuestDTO("Pera", "Peric", "pera123@gmail.com");
    }

    @Override
    public GuestDTO insert(GuestDTO guest) {
        return guest;
    }

    @Override
    public GuestDTO update(GuestDTO guest) {
        return guest;
    }

    @Override
    public void delete(Long id) {
    }
}
