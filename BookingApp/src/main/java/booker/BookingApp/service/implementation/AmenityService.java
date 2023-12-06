package booker.BookingApp.service.implementation;

import booker.BookingApp.dto.accommodation.AmenityDTO;
import booker.BookingApp.model.accommodation.Accommodation;
import booker.BookingApp.model.accommodation.Amenity;
import booker.BookingApp.model.accommodation.Image;
import booker.BookingApp.service.interfaces.IAmenityService;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Long;

@Service
public class AmenityService implements IAmenityService {
    @Override
    public ArrayList<AmenityDTO> findAllAmenitiesForAccommodation(Long accommodationId) throws IOException {
        ArrayList<AmenityDTO> amenities = new ArrayList<>();
        amenities.add(new AmenityDTO(1L, "wifi", "../../../assets/images/icons8-wifi-30.png"));
        amenities.add(new AmenityDTO(2L, "good place", "../../../assets/images/icons8-location-32.png"));
        amenities.add(new AmenityDTO(3L, "AC", "../../../assets/images/icons8-ac-30.png"));
        amenities.add(new AmenityDTO(4L, "free cancellation", "../../../assets/images/icons8-calendar-32.png"));
        return amenities;
    }

    @Override
    public AmenityDTO create(AmenityDTO amenityDTO) {
        return amenityDTO;
    }

    @Override
    public AmenityDTO update(AmenityDTO amenityDTO) {
        return amenityDTO;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public ArrayList<AmenityDTO> findAll() throws IOException {
        return findAllAmenitiesForAccommodation(1L);
    }

    @Override
    public ArrayList<String> getAllNames() {
        return new ArrayList<>(Arrays.asList("wi-fi", "ac", "coffee machine"));
    }
}