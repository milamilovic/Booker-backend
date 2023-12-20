package booker.BookingApp.controller.accommodation;

import booker.BookingApp.dto.accommodation.AccommodationViewDTO;
import booker.BookingApp.dto.accommodation.AddressDTO;
import booker.BookingApp.dto.accommodation.AmenityDTO;
import booker.BookingApp.model.accommodation.Address;
import booker.BookingApp.model.accommodation.Amenity;
import booker.BookingApp.model.accommodation.Filter;
import booker.BookingApp.service.implementation.AccommodationService;
import booker.BookingApp.service.interfaces.IAccommodationService;
import booker.BookingApp.service.interfaces.IAmenityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/amenities")
@CrossOrigin(origins = "http://localhost:4200")
//all of these endpoints are available to unauthorized and authorized users
public class AmenityController {
    @Autowired
    IAmenityService service;

    //get amenities of accommodation
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ArrayList<AmenityDTO>> findAmenitiesForAccommodation(@PathVariable Long id) throws IOException {
        ArrayList<AmenityDTO> accommodation = service.findAllAmenitiesForAccommodation(id);
        return new ResponseEntity<>(accommodation, HttpStatus.OK);
    }

    //get all amenities
    @GetMapping(value ="/all", produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<ArrayList<AmenityDTO>> getAll() throws IOException {
        ArrayList<AmenityDTO> accommodations = service.findAll();
        System.out.println(accommodations);
        return new ResponseEntity<>(accommodations, HttpStatus.OK);
    }

    //get names of all amenities
    @GetMapping(value = "/names", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<String>> getNames() throws IOException {
        List<String> names = service.getAllNames();
        return new ResponseEntity<List<String>>(names, HttpStatus.OK);
    }

    @PutMapping(value = "update/{accommodationId}/amenities" , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateAmenities(@PathVariable("accommodationId")Long accommodationId,
                                                             @RequestBody Amenity[] amenities) {
        try{
            service.updateAmenities(amenities, accommodationId);
            return new ResponseEntity<>("Successful", HttpStatus.OK);
        } catch (Exception e){
            System.out.println(e);
            return new ResponseEntity<>("Bad address update",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
