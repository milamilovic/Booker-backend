package booker.BookingApp.controller.users;


import booker.BookingApp.dto.users.GuestDTO;
import booker.BookingApp.dto.users.OwnerDTO;
import booker.BookingApp.dto.users.UpdateUserDTO;
import booker.BookingApp.service.implementation.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/owners")
@CrossOrigin(origins = "http://localhost:4200")
public class OwnerController {
    private final OwnerService ownerService;

    @Autowired
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping(value = "/all")
    public ResponseEntity<ArrayList<OwnerDTO>> getAll() {
        ArrayList<OwnerDTO> owners = ownerService.findAll();
        return new ResponseEntity<>(owners, HttpStatus.OK);
    }

    @GetMapping(value = "/{ownerId}")
    public ResponseEntity<OwnerDTO> getOwnerById(@PathVariable Long ownerId) {
        OwnerDTO ownerDTO = ownerService.getOwnerById(ownerId);
        if(ownerDTO == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(ownerDTO, HttpStatus.OK);
        }
    }

    @GetMapping(value = "/by-email/{email}")
    public ResponseEntity<OwnerDTO> getOwnerByEmail(@PathVariable String email) {
        OwnerDTO ownerDTO = ownerService.getOwnerByEmail(email);
        if (ownerDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(ownerDTO, HttpStatus.OK);
        }
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<OwnerDTO> insert(@RequestBody OwnerDTO owner) {
        OwnerDTO ownerDTO = ownerService.insert(owner);
        return new ResponseEntity<>(ownerDTO, HttpStatus.OK);
    }

    @PutMapping(value = "/{ownerId}")
    public ResponseEntity<OwnerDTO> update(@PathVariable("ownerId") Long id, @RequestBody UpdateUserDTO updateUserDTO) {
        try{
            OwnerDTO existingOwner = ownerService.getOwnerById(id);
            if(existingOwner == null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            OwnerDTO updatedOwner = ownerService.update(existingOwner, updateUserDTO);
            return new ResponseEntity<>(updatedOwner, HttpStatus.OK);
        }catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/{ownerId}")
    public ResponseEntity<Boolean> delete(@PathVariable Long ownerId) {
        OwnerDTO ownerDTO = ownerService.getOwnerById(ownerId);
        if (ownerDTO == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else{
            Boolean deleted = ownerService.delete(ownerId);
            return new ResponseEntity<>(deleted, HttpStatus.OK);
        }
    }

    // admin blocks the owner by id
    @PutMapping(consumes = "application/json", value = "/block/{ownerId}")
    public ResponseEntity<Void> block(@PathVariable Long ownerId) {
        OwnerDTO ownerDTO = ownerService.getOwnerById(ownerId);
        if (ownerDTO == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else{
            ownerService.block(ownerId);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @PutMapping(consumes ="application/json", value = "/report/{guestEmail}")
    public ResponseEntity<GuestDTO> reportGuest(@PathVariable String guestEmail) {
        GuestDTO guestDTO = ownerService.reportGuest(guestEmail);
        if (guestDTO == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else{
            return new ResponseEntity<>(guestDTO, HttpStatus.OK);
        }
    }

    // get all owner's guests
    // get all owner's notifications

}

