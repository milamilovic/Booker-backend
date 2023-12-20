package booker.BookingApp.service.implementation;

import booker.BookingApp.dto.accommodation.AmenityDTO;
import booker.BookingApp.model.accommodation.Accommodation;
import booker.BookingApp.model.accommodation.Amenity;
import booker.BookingApp.repository.AccommodationRepository;
import booker.BookingApp.repository.AmenityRepository;
import booker.BookingApp.service.interfaces.IAmenityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.lang.Long;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AmenityService implements IAmenityService {
    @Autowired
    AmenityRepository repository;

    @Autowired
    AccommodationRepository accommodationRepository;

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
    public void removeAmenityFromAcc(String amenity_name, Long accId) {
        repository.removeAmenityFromAcc(amenity_name, accId);
    }

    @Override
    public ArrayList<AmenityDTO> findAll() throws IOException {
        ArrayList<Amenity> amenities = (ArrayList<Amenity>) repository.findAllDistinct();
        ArrayList<AmenityDTO> dtos = new ArrayList<>();
        HashMap<String, Amenity> map = new HashMap<String, Amenity>();
        for(Amenity a: amenities) {
            if (!map.containsKey(a.getName())){
                map.put(a.getName(), a);
                dtos.add(AmenityDTO.makeFromAmenity(a));
            }
        }
        return dtos;
    }

    @Override
    public ArrayList<String> getAllNames() {
        return (ArrayList<String>) this.repository.getDistinctNames();
    }

    @Override
    public ArrayList<String> getAllAmenityNamesForAccommodation(Long accommodationId) {
        return (ArrayList<String>) this.repository.getNamesForAcc(accommodationId);
    }

    @Override
    public void updateAmenities(Amenity[] amenities, Long accommodationId){
        repository.deleteByAccommodationId(accommodationId);
        List<Amenity> newAmenities = Arrays.stream(amenities)
                .map(amenityDTO -> {
                    Amenity amenity = new Amenity();
                    amenity.setName(amenityDTO.getName());
                    amenity.setImage_path(amenityDTO.getImage_path());
                    Accommodation accommodation = accommodationRepository.findById(accommodationId).orElse(null);
                    if (accommodation != null) {
                        amenity.setAccommodation(accommodation);
                    } else {
                        System.out.println("error");
                    }
                    return amenity;
                })
                .collect(Collectors.toList());

        repository.saveAll(newAmenities);
    }
}