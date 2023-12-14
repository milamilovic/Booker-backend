package booker.BookingApp.service.implementation;

import booker.BookingApp.dto.users.GuestDTO;
import booker.BookingApp.dto.users.OwnerDTO;
import booker.BookingApp.dto.users.UpdateUserDTO;
import booker.BookingApp.enums.Role;
import booker.BookingApp.model.users.Owner;
import booker.BookingApp.model.users.ProfilePicture;
import booker.BookingApp.model.users.User;
import booker.BookingApp.repository.UserRepository;
import booker.BookingApp.service.interfaces.IOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OwnerService implements IOwnerService {

    @Autowired
    UserRepository userRepository;

    @Override
    public ArrayList<OwnerDTO> findAll() {
        List<Owner> owners = userRepository.getAllOwners();
        ArrayList<OwnerDTO> dtos = new ArrayList<>();
        for(Owner o : owners){
            dtos.add(OwnerDTO.makeFromOwner(o));
        }
        return dtos;
    }

    @Override
    public OwnerDTO getOwnerById(Long id) {
        System.out.println(id);
        Owner o = (Owner) userRepository.getOne(id);
        return OwnerDTO.makeFromOwner(o);
    }

    @Override
    public OwnerDTO getOwnerByEmail(String email) {
        ProfilePicture profilePicture = new ProfilePicture(1L, "src/main/resources/images/profile1.png", new User());
        return new OwnerDTO(1L, "Mika", "Mikic", "mika123@gmail.com", "bbbb", null, null, Role.OWNER, profilePicture, false, false, false, null, null);
    }

    @Override
    public OwnerDTO insert(OwnerDTO owner) {
        return owner;
    }

    @Override
    public OwnerDTO update(OwnerDTO owner, UpdateUserDTO updateUser) {
        Owner o = (Owner) userRepository.getOne(owner.getId());
        if(o != null){
            o.setName(updateUser.getName());
            o.setSurname(updateUser.getSurname());
            o.setEmail(updateUser.getEmail());
            o.setAddress(updateUser.getAddress());
            o.setPhone(updateUser.getPhone());
            o.setProfilePicturePath(updateUser.getProfilePicture().getPath());
            o.setPassword(updateUser.getPassword());
            userRepository.save(o);
            return OwnerDTO.makeFromOwner(o);
        }
        return owner;
    }

    @Override
    public Boolean delete(OwnerDTO owner) {
        if (checkForDeletion(owner.getId())){
            Owner deletedOwner = (Owner) userRepository.delete(owner.getId());
            // TODO log out owner
            deleteAllAccommodation(owner.getId());
            return true;
        }
        return false;
    }

    @Override
    public void deleteAllAccommodation(Long ownerId) {

    }

    @Override
    public boolean checkForDeletion(Long ownerId) {
        // TODO get all active reservations for all owners accommodation
        // TODO if reservations.length == 0 return true
        // TODO else
        return false;
    }

    @Override
    public void block(Long id) {
    }

    @Override
    public GuestDTO reportGuest(String guestEmail) {
        ProfilePicture profilePicture = new ProfilePicture(1L, "src/main/resources/images/profile1.png", new User());
        return new GuestDTO(1L, "Pera", "Peric", "pera123@gmail.com", "aaaa", null, null, Role.GUEST, profilePicture, true, false, false, null);
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
