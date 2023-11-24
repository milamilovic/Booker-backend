/*package booker.BookingApp.controller;

import booker.BookingApp.dto.accommodation.AccommodationDTO;
import booker.BookingApp.model.accommodation.*;
import booker.BookingApp.service.implementation.AccommodationService;
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
    public ResponseEntity<AccommodationDTO> insert(@RequestBody AccommodationDTO accommodation) throws Exception {
        AccommodationDTO dto = service.create(accommodation);
        return new ResponseEntity<AccommodationDTO>(dto, HttpStatus.OK);
    }

    //get one accommodation
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AccommodationDTO> findAccommodation(@PathVariable Long id) throws IOException {
        AccommodationDTO accommodation = service.findOne(id);
        return new ResponseEntity<>(accommodation, HttpStatus.OK);
    }

    //get all accommodations
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ArrayList<AccommodationDTO>> getAll() throws IOException {
        ArrayList<AccommodationDTO> accommodations = service.findAll();
        return new ResponseEntity<ArrayList<AccommodationDTO>>(accommodations, HttpStatus.OK);
    }

    //find accepted accommodations for owner
    @GetMapping(value = "/owner/{ownerId}/active", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ArrayList<AccommodationDTO>> findOwnersAcceptedAccommodations(@PathVariable Long ownerId)
    {
        ArrayList<AccommodationDTO> accommodations = service.findOwnersActiveAccommodations(ownerId);
        return new ResponseEntity<ArrayList<AccommodationDTO>>(accommodations, HttpStatus.OK);
    }

    //find all accommodations for owner
    @GetMapping(value = "/owner/{ownerId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ArrayList<AccommodationDTO>> findAllOwnersAccommodations(@PathVariable Long ownerId)
    {
        ArrayList<AccommodationDTO> accommodations = service.findAllOwnersAccommodations(ownerId);
        return new ResponseEntity<ArrayList<AccommodationDTO>>(accommodations, HttpStatus.OK);
    }

    //    searching accommodations, path looks like
    //   /api/accommodations/search?startDate=12.12.2023.&endDate=15.12.2023.&location=Paris&people=2
    @GetMapping(value = "/search/{startDate}/{endDate}/{location}/{people}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ArrayList<AccommodationDTO>> searchAccommodations(@PathVariable String startDate,
                                                                                   @PathVariable String endDate,
                                                                                   @PathVariable String location,
                                                                                   @PathVariable int people)
    {
        ArrayList<AccommodationDTO> accommodations = service.search(startDate, endDate, location, people);
        return new ResponseEntity<ArrayList<AccommodationDTO>>(accommodations, HttpStatus.OK);
    }

    //   searching accommodations with filters, path looks like
    //   /api/accommodations/search?startDate=12.12.2023.&endDate=15.12.2023.&location=Paris&people=2
    //   and request body contains json with filter array
    @GetMapping(value = "/search/{startDate}/{endDate}/{location}/{people}/filter", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ArrayList<AccommodationDTO>> searchAndFilterAccommodations(@PathVariable String startDate,
                                                                                            @PathVariable String endDate,
                                                                                            @PathVariable String location,
                                                                                            @PathVariable int people,
                                                                                            @RequestBody ArrayList<Filter> filters)
    {
        ArrayList<AccommodationDTO> accommodations = service.search(startDate, endDate, location, people);
        //TODO: make actual filter methods that service.applyFilter redirects to!!!
        for(Filter filter : filters) {
            accommodations = service.applyFilters(accommodations, filter);
        }
        return new ResponseEntity<ArrayList<AccommodationDTO>>(accommodations, HttpStatus.OK);
    }

    //find guests favourite accommodations
    @GetMapping(value = "/guest/{guestId}/favourite", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ArrayList<AccommodationDTO>> findGuestsFavouriteAccommodations(@PathVariable Long guestId)
    {
        ArrayList<AccommodationDTO> accommodations = service.findGuestsFavouriteAccommodations(guestId);
        return new ResponseEntity<ArrayList<AccommodationDTO>>(accommodations, HttpStatus.OK);
    }

    //admin - get all unapproved accommodations
    @GetMapping(value = "/admin/unapproved", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ArrayList<AccommodationDTO>> findUnapprovedAccommodations()
    {
        ArrayList<AccommodationDTO> accommodations = service.findUnapprovedAccommodations();
        return new ResponseEntity<ArrayList<AccommodationDTO>>(accommodations, HttpStatus.OK);
    }

    //remove from favourite for user
    @DeleteMapping(value = "/user/{userId}/remove-favourite/{accommodationId}")
    public ResponseEntity<Void> removeFavoriteAccommodation(@PathVariable Long userId, @PathVariable Long accommodationId) {
        service.removeFavoriteAccommodation(userId, accommodationId);

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
    public ResponseEntity<Void> updateAccommodation(@RequestBody AccommodationDTO updatedAccommodation) throws Exception {
        service.update(updatedAccommodation);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
*/