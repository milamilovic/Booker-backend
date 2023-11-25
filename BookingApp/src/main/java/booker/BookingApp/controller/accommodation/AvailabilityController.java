package booker.BookingApp.controller.accommodation;

import booker.BookingApp.dto.accommodation.AvailabilityDTO;
import booker.BookingApp.service.interfaces.IAvailabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@RestController
@RequestMapping("/api/availability")
public class AvailabilityController {
    @Autowired
    IAvailabilityService service;

    //create an availability
    @PostMapping(value = "/{accommodationId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AvailabilityDTO> insert(@RequestBody AvailabilityDTO amenity, @PathVariable Long accommodationId)  {
        AvailabilityDTO dto = service.create(accommodationId, amenity);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    //get availabilty of accommodation
    @GetMapping(value = "/{id}/{startDate}/{endDate}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ArrayList<AvailabilityDTO>> findAllFreeInRange(@PathVariable Long id, @PathVariable Date startDate, @PathVariable Date endDate) throws IOException {
        ArrayList<AvailabilityDTO> accommodation = service.findAllFreeInRange(id, startDate, endDate);
        return new ResponseEntity<>(accommodation, HttpStatus.OK);
    }
    //delete amenity
    @DeleteMapping(value = "/{id}/{startDate}/{endDate}")
    public ResponseEntity<Void> deleteAvailability(@PathVariable Long id, @PathVariable Date startDate, @PathVariable Date endDate) {
        service.markAsNotAvailable(id, startDate, endDate);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //update amenity
    @PutMapping(value = "/{accommodationId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateAvailability(@RequestBody AvailabilityDTO updatedAvailability, @PathVariable Long accommodationId)  {
        service.update(accommodationId, updatedAvailability);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //get names of all amenities
    @GetMapping(value = "/{id}/{date}")
    public ResponseEntity<Boolean> checkForDate(@PathVariable Long id, @PathVariable Date date) {
        boolean available = service.checkForDate(id, date);
        return new ResponseEntity<>(available, HttpStatus.OK);
    }
}
