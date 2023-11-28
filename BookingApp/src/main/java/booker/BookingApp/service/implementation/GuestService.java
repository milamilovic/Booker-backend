package booker.BookingApp.service.implementation;

import booker.BookingApp.dto.users.GuestDTO;
import booker.BookingApp.enums.Role;
import booker.BookingApp.model.users.Guest;
import booker.BookingApp.service.interfaces.IGuestService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
@Service
public class GuestService implements IGuestService {
    @Override
    public ArrayList<GuestDTO> findAll() {
        GuestDTO g1 = new GuestDTO(1L, "Pera", "Peric", "pera123@gmail.com", null, null, Role.GUEST, false, false, null);
        GuestDTO g2 = new GuestDTO(1L, "Pera", "Peric", "pera123@gmail.com", null, null, Role.GUEST, false, false, null);
        GuestDTO g3 = new GuestDTO(1L, "Pera", "Peric", "pera123@gmail.com", null, null, Role.GUEST, false, false, null);
        GuestDTO g4 = new GuestDTO(1L, "Pera", "Peric", "pera123@gmail.com", null, null, Role.GUEST, false, false, null);
        GuestDTO g5 = new GuestDTO(1L, "Pera", "Peric", "pera123@gmail.com", null, null, Role.GUEST, false, false, null);
        GuestDTO g6 = new GuestDTO(1L, "Pera", "Peric", "pera123@gmail.com", null, null, Role.GUEST, false, false, null);
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
        return new GuestDTO(1L, "Pera", "Peric", "pera123@gmail.com", null, null, Role.GUEST, false, false, null);
    }

    @Override
    public GuestDTO getGuestByEmail(String email) {
        return new GuestDTO(1L, "Pera", "Peric", "pera123@gmail.com", null, null, Role.GUEST, false, false, null);
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

    @Override
    public ArrayList<Long> addToFavouriteAccommodations(GuestDTO guest, Long accommodationId) {
        return null;
    }

    @Override
    public ArrayList<Long> removeFromFavouriteAccommodations(GuestDTO guest, Long accommodationId) {
        return null;
    }
}
