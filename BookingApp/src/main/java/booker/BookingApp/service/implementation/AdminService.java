package booker.BookingApp.service.implementation;

import booker.BookingApp.dto.users.AdminDTO;
import booker.BookingApp.dto.users.UserDTO;
import booker.BookingApp.enums.Role;
import booker.BookingApp.model.users.Admin;
import booker.BookingApp.model.users.ProfilePicture;
import booker.BookingApp.model.users.User;
import booker.BookingApp.service.interfaces.IAdminService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AdminService implements IAdminService {


    @Override
    public AdminDTO update(AdminDTO admin) {
        ProfilePicture profilePicture = new ProfilePicture(1L, "src/main/resources/images/profile1.png", new User());
        return new AdminDTO(1L, "Admin", "Admin", "admin123@gmail.com", null, null, Role.ADMIN, profilePicture);
    }

    @Override
    public AdminDTO get() {
        ProfilePicture profilePicture = new ProfilePicture(1L, "src/main/resources/images/profile1.png", new User());
        return new AdminDTO(1L, "Admin", "Admin", "admin123@gmail.com", null, null, Role.ADMIN, profilePicture);
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
