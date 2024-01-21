package booker.BookingApp.service.interfaces;

import booker.BookingApp.dto.users.AdminDTO;
import booker.BookingApp.dto.users.UpdateUserDTO;
import booker.BookingApp.dto.users.UserDTO;

import java.util.ArrayList;

public interface IAdminService {
    AdminDTO update(AdminDTO admin, UpdateUserDTO updateUserDTO);
    AdminDTO get(Long id);
    ArrayList<UserDTO> getAllBlocked();
    ArrayList<UserDTO> getAllReported();
}
