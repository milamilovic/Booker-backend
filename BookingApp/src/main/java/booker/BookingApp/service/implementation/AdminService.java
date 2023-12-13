package booker.BookingApp.service.implementation;

import booker.BookingApp.dto.users.AdminDTO;
import booker.BookingApp.dto.users.UpdateUserDTO;
import booker.BookingApp.dto.users.UserDTO;
import booker.BookingApp.enums.Role;
import booker.BookingApp.model.users.Admin;
import booker.BookingApp.model.users.ProfilePicture;
import booker.BookingApp.model.users.User;
import booker.BookingApp.repository.UserRepository;
import booker.BookingApp.service.interfaces.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import static booker.BookingApp.dto.users.AdminDTO.makeFromAdmin;

@Service
public class AdminService implements IAdminService {

    @Autowired
    UserRepository userRepository;

    @Override
    public AdminDTO update(AdminDTO admin, UpdateUserDTO updateUser) {
        Admin a = userRepository.getAdmin();
        if(a != null){
            a.setName(updateUser.getName());
            a.setSurname(updateUser.getSurname());
            a.setEmail(updateUser.getEmail());
            a.setAddress(updateUser.getAddress());
            a.setPhone(updateUser.getPhone());
            a.setProfilePicturePath(updateUser.getProfilePicture().getPath());
            a.setPassword(updateUser.getPassword());
            userRepository.save(a);
            return AdminDTO.makeFromAdmin(a);
        }
        return admin;
    }

    @Override
    public AdminDTO get(Long id) {
        Admin a = (Admin) userRepository.getOne(id);
        return AdminDTO.makeFromAdmin(a);
    }

    @Override
    public ArrayList<UserDTO> getAllBlocked() {
        GuestService guestService = new GuestService();
        OwnerService ownerService = new OwnerService();
        ArrayList<UserDTO> blocked = new ArrayList<>(guestService.getAllBlocked());
        blocked.addAll(ownerService.getAllBlocked());
        return blocked;
    }

    @Override
    public ArrayList<UserDTO> getAllReported() {
        GuestService guestService = new GuestService();
        OwnerService ownerService = new OwnerService();
        ArrayList<UserDTO> reported = new ArrayList<>(guestService.getAllReported());
        reported.addAll(ownerService.getAllReported());
        return reported;
    }
}
