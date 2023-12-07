package booker.BookingApp.service.implementation;

import booker.BookingApp.dto.accommodation.AccommodationListingDTO;
import booker.BookingApp.dto.users.GuestDTO;
import booker.BookingApp.dto.users.OwnerDTO;
import booker.BookingApp.dto.users.UpdateUserDTO;
import booker.BookingApp.enums.Role;
import booker.BookingApp.model.users.ProfilePicture;
import booker.BookingApp.model.users.User;
import booker.BookingApp.repository.UserRepository;
import booker.BookingApp.service.interfaces.IGuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
@Service
public class GuestService implements IGuestService {

    @Autowired
    UserRepository userRepository;

    @Override
    public ArrayList<GuestDTO> findAll() {
        ArrayList<Long> faves = new ArrayList<>();
        faves.add(1L); faves.add(2L);
        ProfilePicture profilePicture = new ProfilePicture(1L, "src/main/resources/images/profile1.png", new User());
        GuestDTO g1 = new GuestDTO(1L, "Pera", "Peric", "pera123@gmail.com", null, null, Role.GUEST, profilePicture, false, false, false, faves, "aaaa");
        GuestDTO g2 = new GuestDTO(2L, "Pera", "Peric", "pera123@gmail.com", null, null, Role.GUEST, profilePicture, false, false, false, faves, "aaaa");
        GuestDTO g3 = new GuestDTO(3L, "Pera", "Peric", "pera123@gmail.com", null, null, Role.GUEST, profilePicture, false, false, false, faves, "aaaa");
        GuestDTO g4 = new GuestDTO(4L, "Pera", "Peric", "pera123@gmail.com", null, null, Role.GUEST, profilePicture, true, true, false,  faves, "aaaa");
        GuestDTO g5 = new GuestDTO(5L, "Pera", "Peric", "pera123@gmail.com", null, null, Role.GUEST, profilePicture, false, false, false, faves, "aaaa");
        GuestDTO g6 = new GuestDTO(6L, "Pera", "Peric", "pera123@gmail.com", null, null, Role.GUEST, profilePicture, false, false, false, faves, "aaaa");
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
        ProfilePicture profilePicture = new ProfilePicture(1L, "../../assets/images/initialProfilePic.png", new User());
        return new GuestDTO(id, "Pera", "Peric", "pera123@gmail.com", "Adresa 123", "3210087", Role.GUEST, profilePicture, false, false, false, faves, "aaaa");
    }

    @Override
    public GuestDTO getGuestByEmail(String email) {
        ArrayList<Long> faves = new ArrayList<>();
        faves.add(1L); faves.add(2L);
        ProfilePicture profilePicture = new ProfilePicture(1L, "src/main/resources/images/profile1.png", new User());
        return new GuestDTO(1L, "Pera", "Peric", "pera123@gmail.com", null, null, Role.GUEST, profilePicture, false, false, false, faves, "aaaa");
    }

    @Override
    public GuestDTO insert(GuestDTO guest) {
        return guest;
    }

    @Override
    public GuestDTO update(GuestDTO guest, UpdateUserDTO updateUser) {
        guest.setName(updateUser.getName());
        guest.setSurname(updateUser.getSurname());
        guest.setEmail(updateUser.getEmail());
        guest.setAddress(updateUser.getAddress());
        guest.setPhone(updateUser.getPhone());
        guest.setProfilePicture(updateUser.getProfilePicture());
        guest.setPassword(updateUser.getPassword());

        // TODO add connection with repository
        return guest;
    }

    @Override
    public void delete(Long id) {
    }

    @Override
    public void block(Long id) {
    }

    @Override
    public OwnerDTO reportOwner(String ownerEmail) {
        ProfilePicture profilePicture = new ProfilePicture(1L, "src/main/resources/images/profile1.png", new User());
        return new OwnerDTO(1L, "Mika", "Mikic", "mika123@gmail.com", null, null, Role.OWNER, profilePicture, true, false, false, null, null);
    }

    @Override
    public ArrayList<GuestDTO> getAllBlocked() {
        ArrayList<GuestDTO> all = findAll();
        ArrayList<GuestDTO> blocked = new ArrayList<>();
        for (GuestDTO g : all){
            if (g.isBlocked()){
                blocked.add(g);
            }
        }
        return blocked;
    }

    @Override
    public ArrayList<GuestDTO> getAllReported() {
        ArrayList<GuestDTO> all = findAll();
        ArrayList<GuestDTO> reported = new ArrayList<>();
        for (GuestDTO g : all){
            if (g.isReported()){
                reported.add(g);
            }
        }
        return reported;
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
