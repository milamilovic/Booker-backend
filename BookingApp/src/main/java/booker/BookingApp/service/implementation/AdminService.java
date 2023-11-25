package booker.BookingApp.service.implementation;

import booker.BookingApp.model.users.Admin;
import booker.BookingApp.service.interfaces.IAdminService;
import org.springframework.stereotype.Service;

@Service
public class AdminService implements IAdminService {

    @Override
    public Admin update(Admin admin) {
        return admin;
    }
}
