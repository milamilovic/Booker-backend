/*package booker.BookingApp.service.implementation;

import booker.BookingApp.dto.accommodation.AccommodationDTO;
import booker.BookingApp.model.accommodation.*;
import booker.BookingApp.service.interfaces.IAccommodationService;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@Service
public class AccommodationService implements IAccommodationService {
    @Override
    public ArrayList<AccommodationDTO> findAll() throws IOException {
        AccommodationDTO accommodation = findOne(1L);
        AccommodationDTO accommodation1 = new AccommodationDTO(1L, "Example accommodation 1", "Description 1", "short description 1", "address of accommodation 1", accommodation.getAmenities(), accommodation.getImages(), accommodation.getAvailabilities(), accommodation.getPrices(), accommodation.getRatings(), accommodation.getComments(), 5);
        AccommodationDTO accommodation2 = new AccommodationDTO(2L, "Example accommodation 2", "Description 2", "short description 2", "address of accommodation 2", accommodation.getAmenities(), accommodation.getImages(), accommodation.getAvailabilities(), accommodation.getPrices(), accommodation.getRatings(), accommodation.getComments(), 5);
        AccommodationDTO accommodation3 = new AccommodationDTO(3L, "Example accommodation 3", "Description 3", "short description 3", "address of accommodation 3", accommodation.getAmenities(), accommodation.getImages(), accommodation.getAvailabilities(), accommodation.getPrices(), accommodation.getRatings(), accommodation.getComments(), 5);
        ArrayList<AccommodationDTO> accommodations = new ArrayList<>();
        accommodations.add(accommodation1);
        accommodations.add(accommodation2);
        accommodations.add(accommodation3);
        return accommodations;
    }

    @Override
    public AccommodationDTO findOne(Long id) throws IOException {
        ArrayList<Image> images = new ArrayList<>();
        images.add(ImageIO.read(new File("src/main/resources/lisbon_image.jpg")));
        images.add(ImageIO.read(new File("src/main/resources/london_image.jpg")));
        images.add(ImageIO.read(new File("src/main/resources/madrid_image.jpg")));
        images.add(ImageIO.read(new File("src/main/resources/paris_image.jpg")));
        ArrayList<Amenity> amenities = new ArrayList<>();
        amenities.add(new Amenity(1L, "wifi", ImageIO.read(new File("src/main/resources/lisbon_image.jpg"))));
        amenities.add(new Amenity(2L, "good place", ImageIO.read(new File("src/main/resources/london_image.jpg"))));
        amenities.add(new Amenity(3L, "AC", ImageIO.read(new File("src/main/resources/madrid_image.jpg"))));
        amenities.add(new Amenity(4L, "parking spot", ImageIO.read(new File("src/main/resources/paris_image.jpg"))));
        ArrayList<Availability> availabilities = new ArrayList<>();
        availabilities.add(new Availability(new Date(), new Date()));
        availabilities.add(new Availability(new Date(), new Date()));
        availabilities.add(new Availability(new Date(), new Date()));
        availabilities.add(new Availability(new Date(), new Date()));
        ArrayList<Price> prices = new ArrayList<>();
        prices.add(new Price());
        prices.add(new Price());
        prices.add(new Price());
        prices.add(new Price());
        ArrayList<AccommodationRating> ratings = new ArrayList<>();
        ratings.add(new AccommodationRating());
        ratings.add(new AccommodationRating());
        ratings.add(new AccommodationRating());
        ratings.add(new AccommodationRating());
        ArrayList<AccommodationComment> comments = new ArrayList<>();
        comments.add(new AccommodationComment());
        comments.add(new AccommodationComment());
        comments.add(new AccommodationComment());
        comments.add(new AccommodationComment());
        AccommodationDTO accommodation = new AccommodationDTO(id, "Example accommodation", "Description 1", "short description 1", "address of accommodation 1", amenities, images, availabilities, prices, ratings, comments, 5);
        return accommodation;
    }

    @Override
    public AccommodationDTO create(AccommodationDTO accommodation) throws Exception {
        return accommodation;
    }

    @Override
    public AccommodationDTO update(AccommodationDTO accommodation) throws Exception {
        return accommodation;
    }

    @Override
    public void delete(Long id) {
        //TODO: delete accommodation
    }

    @Override
    public ArrayList<AccommodationDTO> findOwnersActiveAccommodations(Long ownerId) {
        try {
            //TODO: this should return accommodation listing dto
            return findAll();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void removeFavoriteAccommodation(Long userId, Long accommodationId) {
        //TODO: remove favourite
    }

    @Override
    public ArrayList<AccommodationDTO> findUnapprovedAccommodations() {
        return findOwnersActiveAccommodations(2L);
    }

    @Override
    public ArrayList<AccommodationDTO> findGuestsFavouriteAccommodations(Long guestId) {
        try {
            //TODO: this should return favourite accommodations dto
            return findAll();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<AccommodationDTO> search(String startDate, String endDate, String location, int people) {
        return findOwnersActiveAccommodations(2L);
    }

    @Override
    public ArrayList<AccommodationDTO> findAllOwnersAccommodations(Long ownerId) {
        return findOwnersActiveAccommodations(2L);
    }

    @Override
    public ArrayList<AccommodationDTO> applyFilters(ArrayList<AccommodationDTO> accommodations, Filter filter) {
        return findOwnersActiveAccommodations(2L);
    }
}*/
