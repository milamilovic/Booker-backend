package booker.BookingApp.service.implementation;

import booker.BookingApp.dto.accommodation.AmenityDTO;
import booker.BookingApp.model.accommodation.Accommodation;
import booker.BookingApp.model.accommodation.Amenity;
import booker.BookingApp.model.accommodation.Image;
import booker.BookingApp.repository.AmenityRepository;
import booker.BookingApp.service.interfaces.IAmenityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Long;

@Service
public class AmenityService implements IAmenityService {
    @Autowired
    AmenityRepository repository;

    @Override
    public ArrayList<AmenityDTO> findAllAmenitiesForAccommodation(Long accommodationId) throws IOException {
        ArrayList<Amenity> amenities = (ArrayList<Amenity>) repository.getAmenitiesByAccommodation_Id(accommodationId);
        ArrayList<AmenityDTO> dtos = new ArrayList<>();
        for(Amenity a: amenities) {
            dtos.add(AmenityDTO.makeFromAmenity(a));
        }
        return dtos;
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
        ArrayList<Amenity> amenities = (ArrayList<Amenity>) repository.findAllDistinct();
        ArrayList<AmenityDTO> dtos = new ArrayList<>();
        for(Amenity a: amenities) {
            dtos.add(AmenityDTO.makeFromAmenity(a));
        }
        return dtos;
    }

    @Override
    public ArrayList<String> getAllNames() {
        return (ArrayList<String>) this.repository.getDistinctNames();
    }
}