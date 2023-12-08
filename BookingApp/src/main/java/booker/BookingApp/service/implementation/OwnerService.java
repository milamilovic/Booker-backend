package booker.BookingApp.service.implementation;

import booker.BookingApp.dto.users.GuestDTO;
import booker.BookingApp.dto.users.OwnerDTO;
import booker.BookingApp.dto.users.UpdateUserDTO;
import booker.BookingApp.enums.Role;
import booker.BookingApp.model.users.Owner;
import booker.BookingApp.model.users.ProfilePicture;
import booker.BookingApp.model.users.User;
import booker.BookingApp.service.interfaces.IOwnerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class OwnerService implements IOwnerService {
    @Override
    public ArrayList<OwnerDTO> findAll() {
        ProfilePicture profilePicture = new ProfilePicture(1L, "src/main/resources/images/profile1.png", new User());
        OwnerDTO o1 = new OwnerDTO(1L, "Mika", "Mikic", "mika123@gmail.com", null, null, Role.OWNER, profilePicture, false, false, false, null, null, "bbbb");
        OwnerDTO o2 = new OwnerDTO(1L, "Mika", "Mikic", "mika123@gmail.com", null, null, Role.OWNER, profilePicture,  false, false, false, null, null, "bbbb");
        OwnerDTO o3 = new OwnerDTO(1L, "Mika", "Mikic", "mika123@gmail.com", null, null, Role.OWNER, profilePicture, false, false, false, null, null, "bbbb");
        OwnerDTO o4 = new OwnerDTO(1L, "Mika", "Mikic", "mika123@gmail.com", null, null, Role.OWNER, profilePicture, true, true, false, null, null, "bbbb");
        OwnerDTO o5 = new OwnerDTO(1L, "Mika", "Mikic", "mika123@gmail.com", null, null, Role.OWNER, profilePicture, false, false, false, null, null, "bbbb");
        OwnerDTO o6 = new OwnerDTO(1L, "Mika", "Mikic", "mika123@gmail.com", null, null, Role.OWNER, profilePicture, true, true, false, null, null, "bbbb");
        ArrayList<OwnerDTO> owners = new ArrayList<>();
        owners.add(o1);
        owners.add(o2);
        owners.add(o3);
        owners.add(o4);
        owners.add(o5);
        owners.add(o6);
        return owners;
    }

    @Override
    public OwnerDTO getOwnerById(Long id) {
        ProfilePicture profilePicture = new ProfilePicture(1L, "../../assets/images/initialProfilePic.png", new User());
        return new OwnerDTO(1L, "Mika", "Mikic", "mika123@gmail.com", "Adresica 123, Novi Sad", "0601234567", Role.OWNER, profilePicture, false, false, false, null, null, "bbbb");
    }

    @Override
    public OwnerDTO getOwnerByEmail(String email) {
        ProfilePicture profilePicture = new ProfilePicture(1L, "src/main/resources/images/profile1.png", new User());
        return new OwnerDTO(1L, "Mika", "Mikic", "mika123@gmail.com", null, null, Role.OWNER, profilePicture, false, false, false, null, null, "bbbb");
    }

    @Override
    public OwnerDTO insert(OwnerDTO owner) {
        return owner;
    }

    @Override
    public OwnerDTO update(OwnerDTO owner, UpdateUserDTO updateUser) {
        owner.setName(updateUser.getName());
        owner.setSurname(updateUser.getSurname());
        owner.setEmail(updateUser.getEmail());
        owner.setAddress(updateUser.getAddress());
        owner.setPhone(updateUser.getPhone());
        owner.setProfilePicture(updateUser.getProfilePicture());
        owner.setPassword(updateUser.getPassword());
        // TODO add connection with repository
        return owner;
    }

    @Override
    public void delete(Long id) {
    }

    @Override
    public void block(Long id) {
    }

    @Override
    public GuestDTO reportGuest(String guestEmail) {
        ProfilePicture profilePicture = new ProfilePicture(1L, "src/main/resources/images/profile1.png", new User());
        return new GuestDTO(1L, "Pera", "Peric", "pera123@gmail.com", null, null, Role.GUEST, profilePicture, true, false, false, null, "aaaa");
    }

    @Override
    public ArrayList<OwnerDTO> getAllBlocked() {
        ArrayList<OwnerDTO> all = findAll();
        ArrayList<OwnerDTO> blocked = new ArrayList<>();
        for (OwnerDTO o : all){
            if(o.isBlocked()){
                blocked.add(o);
            }
        }
        return blocked;
    }

    @Override
    public ArrayList<OwnerDTO> getAllReported() {
        ArrayList<OwnerDTO> all = findAll();
        ArrayList<OwnerDTO> reported = new ArrayList<>();
        for (OwnerDTO o : all){
            if(o.isReported()){
                reported.add(o);
            }
        }
        return reported;
    }


}
