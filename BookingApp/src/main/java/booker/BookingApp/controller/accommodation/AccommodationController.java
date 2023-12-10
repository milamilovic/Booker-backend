package booker.BookingApp.controller.accommodation;

import booker.BookingApp.dto.accommodation.AccommodationListingDTO;
import booker.BookingApp.dto.accommodation.AccommodationViewDTO;
import booker.BookingApp.dto.accommodation.CreateAccommodationDTO;
import booker.BookingApp.enums.AccommodationType;
import booker.BookingApp.model.accommodation.*;
import booker.BookingApp.service.interfaces.IAccommodationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

@RestController
@RequestMapping("/api/accommodations")
@CrossOrigin(origins = "http://localhost:4200")
public class AccommodationController {

    @Autowired
    IAccommodationService service;

    //create an accommodation
    @PostMapping(value ="/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AccommodationViewDTO> insert(@RequestBody CreateAccommodationDTO accommodation) throws Exception {
        AccommodationViewDTO dto = service.create(accommodation);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    //get one accommodation
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AccommodationViewDTO> findAccommodation(@PathVariable Long id) throws IOException {
        AccommodationViewDTO accommodation = service.findOne(id);
        System.out.println(accommodation.toString());
        return new ResponseEntity<>(accommodation, HttpStatus.OK);
    }

    //get all accommodations
    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
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
        System.out.println("searching without filters");
        ArrayList<AccommodationListingDTO> accommodations = service.search(startDate, endDate, location, people);
        return new ResponseEntity<>(accommodations, HttpStatus.OK);
    }

    //   searching accommodations with filters, path looks like
    //   /api/accommodations/search/12.12.2023./15.12.2023./Paris/2
    //   and request body contains json with filter array
    @PostMapping(value = "/search/{startDate}/{endDate}/{location}/{people}/filter", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ArrayList<AccommodationListingDTO>> searchAndFilterAccommodations(@PathVariable String startDate,
                                                                                            @PathVariable String endDate,
                                                                                            @PathVariable String location,
                                                                                            @PathVariable int people,
                                                                                            @RequestBody ArrayList<Filter> filters) throws IOException {
        ArrayList<AccommodationListingDTO> accommodations = service.search(startDate, endDate, location, people);
        System.out.println(filters.size());
        ArrayList<String> types = new ArrayList<>(Arrays.asList("room", "hotel", "villa", "studio"));
        ArrayList<AccommodationType> adequateTypes = new ArrayList<>();
        for(Filter filter : filters) {
            if(!types.contains(filter.getName())) {
                accommodations = service.applyFilters(accommodations, filter);
            } else {
                //else it's filtering by accommodation type
                //it's different because we're not excluding an accommodation if it's not that because
                //if it's not a room it doesn't mean it's not a hotel
                if(filter.getName().equals("room")) {
                    adequateTypes.add(AccommodationType.ROOM);
                } else if(filter.getName().equals("hotel")) {
                    adequateTypes.add(AccommodationType.HOTEL);
                } else if(filter.getName().equals("studio")) {
                    adequateTypes.add(AccommodationType.STUDIO);
                } else if(filter.getName().equals("villa")) {
                    adequateTypes.add(AccommodationType.VILLA);
                }
            }
        }
        //now, we filter by accommodation type
        //we know that not all are needed - we wouldn't have this type of filter than (thanks to frontend)
        accommodations = service.filterTypes(accommodations, adequateTypes);
        return new ResponseEntity<>(accommodations, HttpStatus.OK);
    }

    //admin - get all unapproved accommodations
    @GetMapping(value = "/admin/unapproved", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ArrayList<AccommodationListingDTO>> findUnapprovedAccommodations()
    {
        ArrayList<AccommodationListingDTO> accommodations = service.findUnapprovedAccommodations();
        return new ResponseEntity<>(accommodations, HttpStatus.OK);
    }

    //admin - decline accommodation
    @DeleteMapping(value = "/admin/remove/{accommodationId}")
    public ResponseEntity<Void> declineAccommodation(@PathVariable Long accommodationId) {
        service.delete(accommodationId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //update accommodation
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateAccommodation(@RequestBody AccommodationViewDTO updatedAccommodation) throws Exception {
        service.update(updatedAccommodation);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
