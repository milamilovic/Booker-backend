package booker.BookingApp.controller;

import booker.BookingApp.dto.accommodation.AccommodationListingDTO;
import booker.BookingApp.dto.accommodation.FavouriteAccommodationDTO;
import booker.BookingApp.model.accommodation.*;
import booker.BookingApp.service.implementation.AccommodationService;
import booker.BookingApp.service.interfaces.IAccommodationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@RestController
@RequestMapping("/api/accommodations")
public class AccommodationController {

    @Autowired
    IAccommodationService service = new AccommodationService();

    //create an accommodation
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Accommodation> insert(@RequestBody Accommodation accommodation)
    {
        return new ResponseEntity<Accommodation>(accommodation, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Accommodation> findAccommodation(@PathVariable Long id) throws IOException {
        Accommodation accommodation = service.findOne(id);
        return new ResponseEntity<>(accommodation, HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ArrayList<Accommodation>> getAll() throws IOException {
        ArrayList<Accommodation> accommodations = service.findAll();
        return new ResponseEntity<ArrayList<Accommodation>>(accommodations, HttpStatus.OK);
    }

    @GetMapping(value = "/owner/{ownerId}/active", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ArrayList<AccommodationListingDTO>> findOwnersAcceptedAccommodations(@PathVariable Long ownerId)
    {
        ArrayList<AccommodationListingDTO> accommodations = service.findOwnersActiveAccommodations(ownerId);
        return new ResponseEntity<ArrayList<AccommodationListingDTO>>(accommodations, HttpStatus.OK);
    }

    @GetMapping(value = "/owner/{ownerId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ArrayList<AccommodationListingDTO>> findAllOwnersAccommodations(@PathVariable Long ownerId)
    {
        ArrayList<AccommodationListingDTO> accommodations = service.findAllOwnersAccommodations(ownerId);
        return new ResponseEntity<ArrayList<AccommodationListingDTO>>(accommodations, HttpStatus.OK);
    }

    //   /api/accommodations/search?startDate=12.12.2023.&endDate=15.12.2023.&location=Paris&people=2
    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ArrayList<AccommodationListingDTO>> searchAccommodations(@RequestParam(required = false) String startDate, @RequestParam(required = false) String endDate, @RequestParam(required = false) String location, @RequestParam(required = false) int people)
    {
        ArrayList<AccommodationListingDTO> accommodations = service.search(startDate, endDate, location, people);
        return new ResponseEntity<ArrayList<AccommodationListingDTO>>(accommodations, HttpStatus.OK);
    }

    @GetMapping(value = "/guest/{guestId}/favourite", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ArrayList<FavouriteAccommodationDTO>> findGuestsFavouriteAccommodations(@PathVariable Long guestId)
    {
        ArrayList<FavouriteAccommodationDTO> accommodations = service.findGuestsFavouriteAccommodations(guestId);
        return new ResponseEntity<ArrayList<FavouriteAccommodationDTO>>(accommodations, HttpStatus.OK);
    }

    @GetMapping(value = "/admin/unapproved", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ArrayList<AccommodationListingDTO>> findUnapprovedAccommodations()
    {
        ArrayList<AccommodationListingDTO> accommodations = service.findUnapprovedAccommodations();
        return new ResponseEntity<ArrayList<AccommodationListingDTO>>(accommodations, HttpStatus.OK);
    }

    @DeleteMapping(value = "/user/{userId}/remove-favourite/{accommodationId}")
    public ResponseEntity<Void> removeFavoriteAccommodation(@PathVariable Long userId, @PathVariable Long accommodationId) {
        service.removeFavoriteAccommodation(userId, accommodationId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateAccommodation(@RequestBody Accommodation updatedAccommodation) throws Exception {
        service.update(updatedAccommodation);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
