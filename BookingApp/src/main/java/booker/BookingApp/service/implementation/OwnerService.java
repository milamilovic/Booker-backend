package booker.BookingApp.service.implementation;

import booker.BookingApp.dto.users.GuestDTO;
import booker.BookingApp.dto.users.OwnerDTO;
import booker.BookingApp.enums.Role;
import booker.BookingApp.model.users.Owner;
import booker.BookingApp.service.interfaces.IOwnerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class OwnerService implements IOwnerService {
    @Override
    public ArrayList<OwnerDTO> findAll() {
        OwnerDTO o1 = new OwnerDTO(1L, "Mika", "Mikic", "mika123@gmail.com", null, null, Role.OWNER, false, false, false, null, null);
        OwnerDTO o2 = new OwnerDTO(1L, "Mika", "Mikic", "mika123@gmail.com", null, null, Role.OWNER, false, false, false, null, null);
        OwnerDTO o3 = new OwnerDTO(1L, "Mika", "Mikic", "mika123@gmail.com", null, null, Role.OWNER, false, false, false, null, null);
        OwnerDTO o4 = new OwnerDTO(1L, "Mika", "Mikic", "mika123@gmail.com", null, null, Role.OWNER, true, true, false, null, null);
        OwnerDTO o5 = new OwnerDTO(1L, "Mika", "Mikic", "mika123@gmail.com", null, null, Role.OWNER, false, false, false, null, null);
        OwnerDTO o6 = new OwnerDTO(1L, "Mika", "Mikic", "mika123@gmail.com", null, null, Role.OWNER, true, true, false, null, null);
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
        return new OwnerDTO(1L, "Mika", "Mikic", "mika123@gmail.com", null, null, Role.OWNER, false, false, false, null, null);
    }

    @Override
    public OwnerDTO getOwnerByEmail(String email) {
        return new OwnerDTO(1L, "Mika", "Mikic", "mika123@gmail.com", null, null, Role.OWNER, false, false, false, null, null);
    }

    @Override
    public OwnerDTO insert(OwnerDTO owner) {
        return owner;
    }

    @Override
    public OwnerDTO update(OwnerDTO owner) {
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
        return new GuestDTO(1L, "Pera", "Peric", "pera123@gmail.com", null, null, Role.GUEST, true, false, false, null);
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
