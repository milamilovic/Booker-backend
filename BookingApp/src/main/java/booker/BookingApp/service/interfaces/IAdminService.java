package booker.BookingApp.service.interfaces;

import booker.BookingApp.dto.users.AdminDTO;

public interface IAdminService {
    AdminDTO update(AdminDTO admin);
    AdminDTO get();
}
