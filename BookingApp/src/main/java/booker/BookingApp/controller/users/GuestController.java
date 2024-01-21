package booker.BookingApp.controller.users;

import booker.BookingApp.dto.accommodation.AccommodationListingDTO;
import booker.BookingApp.dto.accommodation.FavouriteAccommodationDTO;
import booker.BookingApp.dto.users.GuestDTO;
import booker.BookingApp.dto.users.OwnerDTO;
import booker.BookingApp.dto.users.UpdateUserDTO;
import booker.BookingApp.model.users.Guest;
import booker.BookingApp.service.implementation.AccommodationService;
import booker.BookingApp.service.implementation.GuestService;
import jakarta.validation.Valid;
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

    @Autowired
    GuestService guestService;

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
    public ResponseEntity<GuestDTO> insert(@Valid @RequestBody GuestDTO guest) {
        GuestDTO guestDTO = guestService.insert(guest);
        return new ResponseEntity<>(guestDTO, HttpStatus.OK);
    }

    @PutMapping(value = "/{guestId}")
    public ResponseEntity<GuestDTO> update(@PathVariable("guestId") Long id, @Valid @RequestBody UpdateUserDTO updateUserDTO) {
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

    @PutMapping(consumes ="application/json", value = "/report/{ownerEmail}")
    public ResponseEntity<OwnerDTO> reportOwner(@PathVariable String ownerEmail) {
        OwnerDTO ownerDTO = guestService.reportOwner(ownerEmail);
        if (ownerDTO == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else{
            return new ResponseEntity<>(ownerDTO, HttpStatus.OK);
        }
    }

    @PutMapping(value = "/favouriteAccommodations/add/{guestId}/{accommodationId}")
    public ResponseEntity<Boolean> addToFavouriteAccommodations(@PathVariable Long accommodationId, @PathVariable Long guestId) throws Exception {
        boolean added = guestService.addToFavouriteAccommodations(guestId, accommodationId);
        return new ResponseEntity<>(added, HttpStatus.OK);
    }

    @PutMapping(value = "/favouriteAccommodations/remove/{guestId}/{accommodationId}")
    public ResponseEntity<Boolean> removeFromFavouriteAccommodations(@PathVariable Long accommodationId, @PathVariable Long guestId) throws Exception {
        boolean added = guestService.removeFromFavouriteAccommodations(guestId, accommodationId);
        return new ResponseEntity<>(added, HttpStatus.OK);
    }

    @GetMapping(value = "/{guestId}/favouriteAccommodations/all")
    public ResponseEntity<ArrayList<FavouriteAccommodationDTO>> findAllFavouriteReservations(@PathVariable Long guestId) throws IOException {
        GuestDTO guestDTO = guestService.getGuestById(guestId);
        ArrayList<FavouriteAccommodationDTO> favourites = guestService.findAllFavouriteAccommodations(guestDTO);
        if (favourites == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(favourites, HttpStatus.OK);
    }

    @GetMapping(value = "/favourites/check/{guestId}/{accId}")
    public ResponseEntity<Boolean> findAllFavouriteReservations(@PathVariable Long guestId, @PathVariable Long accId) throws IOException {
        boolean isFavourite = this.guestService.isFavourite(guestId, accId);
        return new ResponseEntity<>(isFavourite, HttpStatus.OK);
    }

    @GetMapping(value = "/{guestId}/cancelled")
    public ResponseEntity<Integer> getNumOfCancellations(@PathVariable Long guestId) {
        int cancellations = guestService.findNumOfCancellations(guestId);
        return new ResponseEntity<>(cancellations, HttpStatus.OK);
    }

    // get all guest's notifications
}
