package booker.BookingApp.controller.users;

import booker.BookingApp.dto.users.*;
import booker.BookingApp.model.users.Admin;
import booker.BookingApp.service.implementation.AdminService;
import booker.BookingApp.service.implementation.GuestService;
import booker.BookingApp.service.implementation.OwnerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {

    @Autowired
    GuestService guestService;
    @Autowired
    OwnerService ownerService;

    @Autowired
    AdminService adminService;

    @PutMapping(value = "/{adminId}")
    public ResponseEntity<AdminDTO> update(@PathVariable("adminId") Long id, @Valid @RequestBody UpdateUserDTO updateUserDTO) {
        try{
            AdminDTO existingAdmin = adminService.get(id);
            if (existingAdmin == null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            AdminDTO updatedAdmin = adminService.update(existingAdmin, updateUserDTO);
            return new ResponseEntity<>(updatedAdmin, HttpStatus.OK);
        }
        catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{adminId}")
    public ResponseEntity<AdminDTO> getAdmin(@PathVariable Long adminId){
        AdminDTO adminDTO = adminService.get(adminId);
        return new ResponseEntity<>(adminDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/blocked")
    public ResponseEntity<ArrayList<UserDTO>> getAllBlockedUsers(){
        ArrayList<UserDTO> blocked = adminService.getAllBlocked();
        return new ResponseEntity<>(blocked, HttpStatus.OK);
    }

    @GetMapping(value = "/blocked/guests")
    public ResponseEntity<ArrayList<GuestDTO>> getAllBlockedGuests(){
        ArrayList<GuestDTO> blocked = guestService.getAllBlocked();
        return new ResponseEntity<>(blocked, HttpStatus.OK);
    }

    @GetMapping(value = "/blocked/owners")
    public ResponseEntity<ArrayList<OwnerDTO>> getAllBlockedOwners(){
        ArrayList<OwnerDTO> blocked = ownerService.getAllBlocked();
        return new ResponseEntity<>(blocked, HttpStatus.OK);
    }

    @GetMapping(value = "/reported")
    public ResponseEntity<ArrayList<UserDTO>> getAllReportedUsers(){
        ArrayList<UserDTO> reported = adminService.getAllReported();
        return new ResponseEntity<>(reported, HttpStatus.OK);
    }

    @GetMapping(value = "/reported/guests")
    public ResponseEntity<ArrayList<GuestDTO>> getAllReportedGuests(){
        ArrayList<GuestDTO> reported = guestService.getAllReported();
        return new ResponseEntity<>(reported, HttpStatus.OK);
    }

    @GetMapping(value = "/reported/owners")
    public ResponseEntity<ArrayList<OwnerDTO>> getAllReportedOwners(){
        ArrayList<OwnerDTO> reported = ownerService.getAllReported();
        return new ResponseEntity<>(reported, HttpStatus.OK);
    }
}
