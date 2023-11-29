package booker.BookingApp.service.implementation;

import booker.BookingApp.dto.accommodation.AccommodationListingDTO;
import booker.BookingApp.dto.users.GuestDTO;
import booker.BookingApp.enums.Role;
import booker.BookingApp.model.users.Guest;
import booker.BookingApp.service.interfaces.IGuestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
@Service
public class GuestService implements IGuestService {
    @Override
    public ArrayList<GuestDTO> findAll() {
        ArrayList<Long> faves = new ArrayList<>();
        faves.add(1L); faves.add(2L);
        GuestDTO g1 = new GuestDTO(1L, "Pera", "Peric", "pera123@gmail.com", null, null, Role.GUEST, false, faves);
        GuestDTO g2 = new GuestDTO(2L, "Pera", "Peric", "pera123@gmail.com", null, null, Role.GUEST, false, faves);
        GuestDTO g3 = new GuestDTO(3L, "Pera", "Peric", "pera123@gmail.com", null, null, Role.GUEST, false, faves);
        GuestDTO g4 = new GuestDTO(4L, "Pera", "Peric", "pera123@gmail.com", null, null, Role.GUEST, false, faves);
        GuestDTO g5 = new GuestDTO(5L, "Pera", "Peric", "pera123@gmail.com", null, null, Role.GUEST, false, faves);
        GuestDTO g6 = new GuestDTO(6L, "Pera", "Peric", "pera123@gmail.com", null, null, Role.GUEST, false, faves);
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
        ArrayList<Long> faves = new ArrayList<>();
        faves.add(1L); faves.add(2L);
        return new GuestDTO(1L, "Pera", "Peric", "pera123@gmail.com", null, null, Role.GUEST, false, faves);
    }

    @Override
    public GuestDTO getGuestByEmail(String email) {
        ArrayList<Long> faves = new ArrayList<>();
        faves.add(1L); faves.add(2L);
        return new GuestDTO(1L, "Pera", "Peric", "pera123@gmail.com", null, null, Role.GUEST, false, faves);
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
        GuestDTO guestDTO = getGuestById(guest.getId());
        if (guestDTO == null){
            return null;
        }
        ArrayList<Long> favourites = guestDTO.getFavouriteAccommodations();
        favourites.add(accommodationId);
        guest.setFavouriteAccommodations(favourites);
        return favourites;
    }

    @Override
    public ArrayList<Long> removeFromFavouriteAccommodations(GuestDTO guest, Long accommodationId) {
        GuestDTO guestDTO = getGuestById(guest.getId());
        if (guestDTO == null){
            return null;
        }
        ArrayList<Long> favourites = guestDTO.getFavouriteAccommodations();
        favourites.remove(accommodationId);
        guest.setFavouriteAccommodations(favourites);
        return favourites;
    }

    @Override
    public ArrayList<AccommodationListingDTO> findAllFavouriteAccommodations(GuestDTO guest) throws IOException {
        ArrayList<Long> favouriteIds = guest.getFavouriteAccommodations();
        ArrayList<AccommodationListingDTO> favourites = new ArrayList<>();
        AccommodationService accommodationService = new AccommodationService();
        ArrayList<AccommodationListingDTO> all = accommodationService.findAll();
        for(AccommodationListingDTO a : all){
            if(favouriteIds.contains(a.getId())){
                favourites.add(a);
            }
        }
        return favourites;
    }


}
