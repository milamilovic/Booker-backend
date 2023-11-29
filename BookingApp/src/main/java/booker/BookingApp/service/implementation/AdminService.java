package booker.BookingApp.service.implementation;

import booker.BookingApp.dto.users.AdminDTO;
import booker.BookingApp.dto.users.UserDTO;
import booker.BookingApp.enums.Role;
import booker.BookingApp.model.users.Admin;
import booker.BookingApp.service.interfaces.IAdminService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AdminService implements IAdminService {


    @Override
    public AdminDTO update(AdminDTO admin) {

        return new AdminDTO(1L, "Admin", "Admin", "admin123@gmail.com", null, null, Role.ADMIN);
    }

    @Override
    public AdminDTO get() {
        return new AdminDTO(1L, "Admin", "Admin", "admin123@gmail.com", null, null, Role.ADMIN);
    }

    @Override
    public ArrayList<UserDTO> getAllBlocked() {
        GuestService guestService = new GuestService();
        OwnerService ownerService = new OwnerService();
        ArrayList<UserDTO> blocked = new ArrayList<>(guestService.getAllBlocked());
        blocked.addAll(ownerService.getAllBlocked());
        return blocked;
    }
}
