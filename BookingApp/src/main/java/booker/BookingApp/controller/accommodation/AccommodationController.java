package booker.BookingApp.controller.accommodation;

import booker.BookingApp.dto.accommodation.AccommodationListingDTO;
import booker.BookingApp.dto.accommodation.FavouriteAccommodationDTO;
import booker.BookingApp.dto.accommodation.WholeAccommodationDTO;
import booker.BookingApp.model.accommodation.*;
import booker.BookingApp.service.interfaces.IAccommodationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/accommodations")
public class AccommodationController {

    @Autowired
    IAccommodationService service;

    //create an accommodation
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WholeAccommodationDTO> insert(@RequestBody WholeAccommodationDTO accommodation) throws Exception {
        WholeAccommodationDTO dto = service.create(accommodation);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    //get one accommodation
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WholeAccommodationDTO> findAccommodation(@PathVariable Long id) throws IOException {
        WholeAccommodationDTO accommodation = service.findOne(id);
        return new ResponseEntity<>(accommodation, HttpStatus.OK);
    }

    //get all accommodations
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ArrayList<AccommodationListingDTO>> getAll() throws IOException {
        ArrayList<AccommodationListingDTO> accommodations = service.findAll();
        return new ResponseEntity<>(accommodations, HttpStatus.OK);
    }

    //find accepted accommodations for owner
    @GetMapping(value = "/owner/{ownerId}/active", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ArrayList<AccommodationListingDTO>> findOwnersAcceptedAccommodations(@PathVariable Long ownerId)
    {
        ArrayList<AccommodationListingDTO> accommodations = service.findOwnersActiveAccommodations(ownerId);
        return new ResponseEntity<>(accommodations, HttpStatus.OK);
    }

    //find all accommodations for owner
    @GetMapping(value = "/owner/{ownerId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ArrayList<AccommodationListingDTO>> findAllOwnersAccommodations(@PathVariable Long ownerId)
    {
        ArrayList<AccommodationListingDTO> accommodations = service.findAllOwnersAccommodations(ownerId);
        return new ResponseEntity<>(accommodations, HttpStatus.OK);
    }

    //    searching accommodations, path looks like
    //   /api/accommodations/search?startDate=12.12.2023.&endDate=15.12.2023.&location=Paris&people=2
    @GetMapping(value = "/search/{startDate}/{endDate}/{location}/{people}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ArrayList<AccommodationListingDTO>> searchAccommodations(@PathVariable String startDate,
                                                                                   @PathVariable String endDate,
                                                                                   @PathVariable String location,
                                                                                   @PathVariable int people)
    {
        ArrayList<AccommodationListingDTO> accommodations = service.search(startDate, endDate, location, people);
        return new ResponseEntity<>(accommodations, HttpStatus.OK);
    }

    //   searching accommodations with filters, path looks like
    //   /api/accommodations/search?startDate=12.12.2023.&endDate=15.12.2023.&location=Paris&people=2
    //   and request body contains json with filter array
    @GetMapping(value = "/search/{startDate}/{endDate}/{location}/{people}/filter", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ArrayList<AccommodationListingDTO>> searchAndFilterAccommodations(@PathVariable String startDate,
                                                                                            @PathVariable String endDate,
                                                                                            @PathVariable String location,
                                                                                            @PathVariable int people,
                                                                                            @RequestBody ArrayList<Filter> filters)
    {
        ArrayList<AccommodationListingDTO> accommodations = service.search(startDate, endDate, location, people);
        //TODO: make actual filter methods that service.applyFilter redirects to!!!
        for(Filter filter : filters) {
            accommodations = service.applyFilters(accommodations, filter);
        }
        return new ResponseEntity<>(accommodations, HttpStatus.OK);
    }

    //find guests favourite accommodations
    @GetMapping(value = "/guest/{guestId}/favourite", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ArrayList<FavouriteAccommodationDTO>> findGuestsFavouriteAccommodations(@PathVariable Long guestId) throws IOException {
        ArrayList<FavouriteAccommodationDTO> accommodations = service.findGuestsFavouriteAccommodations(guestId);
        return new ResponseEntity<>(accommodations, HttpStatus.OK);
    }

    //admin - get all unapproved accommodations
    @GetMapping(value = "/admin/unapproved", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ArrayList<AccommodationListingDTO>> findUnapprovedAccommodations()
    {
        ArrayList<AccommodationListingDTO> accommodations = service.findUnapprovedAccommodations();
        return new ResponseEntity<>(accommodations, HttpStatus.OK);
    }

    //remove from favourite for guest
    @DeleteMapping(value = "/guest/{guestId}/remove-favourite/{accommodationId}")
    public ResponseEntity<Void> removeFavoriteAccommodation(@PathVariable Long guestId, @PathVariable Long accommodationId) {
        service.removeFavoriteAccommodation(guestId, accommodationId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    //admin - decline accommodation
    @DeleteMapping(value = "/admin/remove/{accommodationId}")
    public ResponseEntity<Void> declineAccommodation(@PathVariable Long accommodationId) {
        service.delete(accommodationId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //update accommodation
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateAccommodation(@RequestBody WholeAccommodationDTO updatedAccommodation) throws Exception {
        service.update(updatedAccommodation);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
