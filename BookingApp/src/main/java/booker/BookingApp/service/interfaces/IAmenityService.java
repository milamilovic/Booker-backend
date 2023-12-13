package booker.BookingApp.service.interfaces;

import booker.BookingApp.dto.accommodation.AmenityDTO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface IAmenityService {
    ArrayList<AmenityDTO> findAllAmenitiesForAccommodation(Long accommodationId) throws IOException;

    AmenityDTO create(AmenityDTO amenityDTO);

    AmenityDTO update(AmenityDTO amenityDTO);

    void delete(Long id);

    ArrayList<AmenityDTO> findAll() throws IOException;

    List<String> getAllNames();
}