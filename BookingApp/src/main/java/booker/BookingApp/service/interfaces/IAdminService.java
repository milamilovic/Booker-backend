package booker.BookingApp.service.interfaces;

import booker.BookingApp.dto.users.AdminDTO;
import booker.BookingApp.dto.users.UserDTO;

import java.util.ArrayList;

public interface IAdminService {
    AdminDTO update(AdminDTO admin);
    AdminDTO get();
    ArrayList<UserDTO> getAllBlocked();
}
