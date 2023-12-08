package booker.BookingApp.service.interfaces;

import booker.BookingApp.dto.users.GuestDTO;
import booker.BookingApp.dto.users.OwnerDTO;
import booker.BookingApp.dto.users.UpdateUserDTO;
import booker.BookingApp.model.users.Owner;

import java.util.ArrayList;

public interface IOwnerService {
    ArrayList<OwnerDTO> findAll();
    OwnerDTO getOwnerById(Long ownerId);
    OwnerDTO getOwnerByEmail(String email);
    OwnerDTO insert(OwnerDTO owner);
    OwnerDTO update(OwnerDTO owner, UpdateUserDTO updateUser);
    void delete(Long ownerId);
    void block(Long ownerId);
    GuestDTO reportGuest(String guestEmail);
    ArrayList<OwnerDTO> getAllBlocked();
    ArrayList<OwnerDTO> getAllReported();
}
