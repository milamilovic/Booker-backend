package booker.BookingApp.controller.users;

import booker.BookingApp.dto.users.AdminDTO;
import booker.BookingApp.model.users.Admin;
import booker.BookingApp.service.implementation.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admins")
public class AdminController {
    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PutMapping(consumes = "application/json")
    public ResponseEntity<AdminDTO> update(@RequestBody AdminDTO admin) throws Exception {
        AdminDTO adminDTO = adminService.update(admin);
        return new ResponseEntity<>(adminDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/get")
    public ResponseEntity<AdminDTO> get(){
        AdminDTO adminDTO = adminService.get();
        return new ResponseEntity<>(adminDTO, HttpStatus.OK);
    }
}
