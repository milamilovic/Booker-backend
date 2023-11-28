package booker.BookingApp.controller.users;

import booker.BookingApp.dto.users.GuestDTO;
import booker.BookingApp.model.users.Guest;
import booker.BookingApp.service.implementation.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/guests")
public class GuestController {
    private final GuestService guestService;

    @Autowired
    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }

    @GetMapping(value = "/all")
    public ResponseEntity<ArrayList<GuestDTO>> getAll() {
        ArrayList<GuestDTO> guests = guestService.findAll();
        return new ResponseEntity<>(guests, HttpStatus.OK);
    }

    @GetMapping(value = "/{guestId}")
    public ResponseEntity<GuestDTO> getGuestById(@PathVariable Long guestId) {
        GuestDTO guestDTO = guestService.getGuestById(guestId);
        if (guestDTO == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(guestDTO, HttpStatus.OK);
        }
    }

    @GetMapping(value = "/by-email/{email}")
    public ResponseEntity<GuestDTO> getGuestByEmail(@PathVariable String email) {
        GuestDTO guestDTO = guestService.getGuestByEmail(email);
        if (guestDTO == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(guestDTO, HttpStatus.OK);
        }
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<GuestDTO> insert(@RequestBody GuestDTO guest) {
        GuestDTO guestDTO = guestService.insert(guest);
        return new ResponseEntity<>(guestDTO, HttpStatus.OK);
    }

    @PutMapping(consumes = "application/json")
    public ResponseEntity<GuestDTO> update(@RequestBody GuestDTO guestDTO) throws Exception {
        GuestDTO guest = guestService.getGuestById(guestDTO.getId());
        if (guest == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        GuestDTO updatedGuest = guestService.update(guest);
        return new ResponseEntity<>(updatedGuest, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{guestId}")
    public ResponseEntity<Void> delete(@PathVariable Long guestId) {
        GuestDTO guest = guestService.getGuestById(guestId);
        if (guest == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            guestService.delete(guestId);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    // get all guest's reservations
    // get all guest's notifications
}
