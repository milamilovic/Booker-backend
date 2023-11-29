package booker.BookingApp.controller.users;

import booker.BookingApp.dto.users.AdminDTO;
import booker.BookingApp.dto.users.GuestDTO;
import booker.BookingApp.dto.users.OwnerDTO;
import booker.BookingApp.dto.users.UserDTO;
import booker.BookingApp.model.users.Admin;
import booker.BookingApp.service.implementation.AdminService;
import booker.BookingApp.service.implementation.GuestService;
import booker.BookingApp.service.implementation.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

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

    @GetMapping(value = "/blocked")
    public ResponseEntity<ArrayList<UserDTO>> getAllBlockedUsers(){
        ArrayList<UserDTO> blocked = adminService.getAllBlocked();
        return new ResponseEntity<>(blocked, HttpStatus.OK);
    }

    @GetMapping(value = "/blocked/guests")
    public ResponseEntity<ArrayList<GuestDTO>> getAllBlockedGuests(){
        GuestService guestService = new GuestService();
        ArrayList<GuestDTO> blocked = guestService.getAllBlocked();
        return new ResponseEntity<>(blocked, HttpStatus.OK);
    }

    @GetMapping(value = "/blocked/owners")
    public ResponseEntity<ArrayList<OwnerDTO>> getAllBlockedOwners(){
        OwnerService ownerService = new OwnerService();
        ArrayList<OwnerDTO> blocked = ownerService.getAllBlocked();
        return new ResponseEntity<>(blocked, HttpStatus.OK);
    }
}
