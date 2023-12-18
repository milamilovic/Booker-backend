package booker.BookingApp.controller.users;

import booker.BookingApp.dto.accommodation.AccommodationListingDTO;
import booker.BookingApp.dto.accommodation.FavouriteAccommodationDTO;
import booker.BookingApp.dto.users.GuestDTO;
import booker.BookingApp.dto.users.OwnerDTO;
import booker.BookingApp.dto.users.UpdateUserDTO;
import booker.BookingApp.model.users.Guest;
import booker.BookingApp.service.implementation.AccommodationService;
import booker.BookingApp.service.implementation.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/guests")
@CrossOrigin(origins = "http://localhost:4200")
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

    @PreAuthorize("hasRole('GUEST')")
    @PutMapping(value = "/{guestId}")
    public ResponseEntity<GuestDTO> update(@PathVariable("guestId") Long id, @RequestBody UpdateUserDTO updateUserDTO) {
        try{
            GuestDTO existingGuest = guestService.getGuestById(id);
            if (existingGuest == null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            GuestDTO updatedGuest = guestService.update(existingGuest, updateUserDTO);
            return new ResponseEntity<>(updatedGuest, HttpStatus.OK);
        }
        catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PreAuthorize("hasRole('GUEST')")
    @PutMapping(value = "/delete/{guestId}")
    public ResponseEntity<Boolean> delete(@PathVariable Long guestId) {
        GuestDTO guest = guestService.getGuestById(guestId);
        if (guest == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            Boolean deleted = guestService.delete(guest);
            return new ResponseEntity<>(deleted, HttpStatus.OK);
        }
    }

    // admin blocks the guest by id
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping(consumes = "application/json", value = "/block/{guestId}")
    public ResponseEntity<Void> block(@PathVariable Long guestId) {
        GuestDTO guest = guestService.getGuestById(guestId);
        if (guest == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            guestService.block(guestId);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @PreAuthorize("hasRole('GUEST')")
    @PutMapping(consumes ="application/json", value = "/report/{ownerEmail}")
    public ResponseEntity<OwnerDTO> reportOwner(@PathVariable String ownerEmail) {
        OwnerDTO ownerDTO = guestService.reportOwner(ownerEmail);
        if (ownerDTO == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else{
            return new ResponseEntity<>(ownerDTO, HttpStatus.OK);
        }
    }

    @PreAuthorize("hasRole('GUEST')")
    @PutMapping(consumes = "application/json", value = "/favouriteAccommodations/add/{accommodationId}")
    public ResponseEntity<ArrayList<Long>> addToFavouriteAccommodations(@RequestBody GuestDTO guestDTO,
                                                                        @PathVariable Long accommodationId) throws Exception {
        ArrayList<Long> favourites = guestService.addToFavouriteAccommodations(guestDTO, accommodationId);
        if (favourites == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(favourites, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('GUEST')")
    @PutMapping(consumes = "application/json", value = "/favouriteAccommodations/remove/{accommodationId}")
    public ResponseEntity<ArrayList<Long>> removeFromFavouriteAccommodations(@RequestBody GuestDTO guestDTO,
                                                                        @PathVariable Long accommodationId) throws Exception {
        ArrayList<Long> favourites = guestService.removeFromFavouriteAccommodations(guestDTO, accommodationId);
        if (favourites == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(favourites, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('GUEST')")
    @GetMapping(value = "/{guestId}/favouriteAccommodations/all")
    public ResponseEntity<ArrayList<AccommodationListingDTO>> findAllFavouriteReservations(@PathVariable Long guestId) throws IOException {
        GuestDTO guestDTO = guestService.getGuestById(guestId);
        ArrayList<AccommodationListingDTO> favourites = guestService.findAllFavouriteAccommodations(guestDTO);
        if (favourites == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(favourites, HttpStatus.OK);
    }

    // get all guest's notifications
}
