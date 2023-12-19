package booker.BookingApp.controller.accommodation;

import booker.BookingApp.dto.accommodation.AvailabilityDTO;
import booker.BookingApp.service.interfaces.IAvailabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

@RestController
@RequestMapping("/api/availability")
@CrossOrigin(origins = "http://localhost:4200")
//all of these methods are open to all users
public class AvailabilityController {
    @Autowired
    IAvailabilityService service;

    //create an availability
    @PreAuthorize("hasRole('OWNER')")
    @PostMapping(value = "/{accommodationId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AvailabilityDTO> insert(@RequestBody AvailabilityDTO availability, @PathVariable Long accommodationId)  {
        AvailabilityDTO dto = service.create(accommodationId, availability);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    //get availabilty of accommodation
    @GetMapping(value = "/{id}/{startDate}/{endDate}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ArrayList<AvailabilityDTO>> findAllFreeInRange(@PathVariable Long id, @PathVariable String startDate, @PathVariable String endDate) throws IOException {
        ArrayList<AvailabilityDTO> accommodation = service.findAllFreeInRange(id, startDate, endDate);
        return new ResponseEntity<>(accommodation, HttpStatus.OK);
    }
    //delete availability
    @DeleteMapping(value = "/{id}/{startDate}/{endDate}")
    public ResponseEntity<Void> deleteAvailability(@PathVariable Long id, @PathVariable String startDate, @PathVariable String endDate) {
        service.markAsNotAvailable(id, startDate, endDate);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //update availability
    @PutMapping(value = "/{accommodationId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateAvailability(@RequestBody AvailabilityDTO updatedAvailability, @PathVariable Long accommodationId)  {
        service.update(accommodationId, updatedAvailability);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //check if accommodation is available for date
    @GetMapping(value = "/{id}/{date}")
    public ResponseEntity<Boolean> checkForDate(@PathVariable Long id, @PathVariable String date) throws ParseException {
        boolean available = service.checkForDate(id, date);
        return new ResponseEntity<>(available, HttpStatus.OK);
    }
}
