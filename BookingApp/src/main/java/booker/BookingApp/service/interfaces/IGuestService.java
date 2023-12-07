package booker.BookingApp.service.interfaces;

import booker.BookingApp.dto.users.GuestDTO;
import booker.BookingApp.dto.accommodation.AccommodationListingDTO;
import booker.BookingApp.dto.users.OwnerDTO;
import booker.BookingApp.dto.users.UpdateUserDTO;

import java.io.IOException;
import java.util.ArrayList;

public interface IGuestService {
    ArrayList<GuestDTO> findAll();
    GuestDTO getGuestById(Long guestId);
    GuestDTO getGuestByEmail(String email);
    GuestDTO insert(GuestDTO guest);
    GuestDTO update(GuestDTO guest, UpdateUserDTO updateUserDTO);
    void delete(Long guestId);
    void block(Long guestId);
    OwnerDTO reportOwner(String ownerEmail);
    ArrayList<GuestDTO> getAllBlocked();
    ArrayList<GuestDTO> getAllReported();
    ArrayList<Long> addToFavouriteAccommodations(GuestDTO guest, Long accommodationId);
    ArrayList<Long> removeFromFavouriteAccommodations(GuestDTO guest, Long accommodationId);
    ArrayList<AccommodationListingDTO> findAllFavouriteAccommodations(GuestDTO guest) throws IOException;
}
