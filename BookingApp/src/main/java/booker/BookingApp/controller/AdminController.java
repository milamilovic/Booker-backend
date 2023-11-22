package booker.BookingApp.controller;

import booker.BookingApp.model.Admin;
import booker.BookingApp.service.implementation.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admins")
public class AdminController {
    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PutMapping("/{adminId}")
    public Admin updateAdmin(@PathVariable Long adminId, @RequestBody Admin admin) throws Exception {
        return adminService.update(admin);
    }
}
