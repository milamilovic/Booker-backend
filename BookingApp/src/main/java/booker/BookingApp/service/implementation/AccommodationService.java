package booker.BookingApp.service.implementation;

import booker.BookingApp.dto.accommodation.AccommodationListingDTO;
import booker.BookingApp.dto.accommodation.FavouriteAccommodationDTO;
import booker.BookingApp.dto.accommodation.WholeAccommodationDTO;
import booker.BookingApp.model.accommodation.*;
import booker.BookingApp.service.interfaces.IAccommodationService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@Service
public class AccommodationService implements IAccommodationService {
    @Override
    public ArrayList<AccommodationListingDTO> findAll() throws IOException {
        WholeAccommodationDTO accommodation = findOne(1L);
        //TODO: images
        AccommodationListingDTO accommodation1 = new AccommodationListingDTO(1L, "Example accommodation 1", "Description 1", 3.2F, 118F, 35F);
        AccommodationListingDTO accommodation2 = new AccommodationListingDTO(2L, "Example accommodation 2", "Description 2", 4.5F, 250F, 50F);
        AccommodationListingDTO accommodation3 = new AccommodationListingDTO(3L, "Example accommodation 3", "Description 3", 5.0F, 18F, 6F);
        ArrayList<AccommodationListingDTO> accommodations = new ArrayList<>();
        accommodations.add(accommodation1);
        accommodations.add(accommodation2);
        accommodations.add(accommodation3);
        return accommodations;
    }

    @Override
    public WholeAccommodationDTO findOne(Long id) throws IOException {
//        ArrayList<Image> images = new ArrayList<>();
//        images.add(ImageIO.read(new File("src/main/resources/lisbon_image.jpg")));
//        images.add(ImageIO.read(new File("src/main/resources/london_image.jpg")));
//        images.add(ImageIO.read(new File("src/main/resources/madrid_image.jpg")));
//        images.add(ImageIO.read(new File("src/main/resources/paris_image.jpg")));
        ArrayList<Amenity> amenities = new ArrayList<>();
        //TODO: FIX!!!
        char[] name = new char[4];
        name[1] = 'w';
        name[1] = 'i';
        name[1] = 'f';
        name[1] = 'i';
        amenities.add(new Amenity(1L, "wifi", new Accommodation()));
        amenities.add(new Amenity(2L, "ad", new Accommodation()));
        amenities.add(new Amenity(3L, "parking", new Accommodation()));
        amenities.add(new Amenity(4L, "coffee machine", new Accommodation()));
//        amenities.add(new Amenity(2L, "good place", ImageIO.read(new File("src/main/resources/london_image.jpg"))));
//        amenities.add(new Amenity(3L, "AC", ImageIO.read(new File("src/main/resources/madrid_image.jpg"))));
//        amenities.add(new Amenity(4L, "parking spot", ImageIO.read(new File("src/main/resources/paris_image.jpg"))));
        ArrayList<Availability> availabilities = new ArrayList<>();
        availabilities.add(new Availability(1L, new Date(), new Date(), new Accommodation()));
        availabilities.add(new Availability(2L, new Date(), new Date(), new Accommodation()));
        availabilities.add(new Availability(3L, new Date(), new Date(), new Accommodation()));
        availabilities.add(new Availability(4L, new Date(), new Date(), new Accommodation()));
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
        //TODO: images
        WholeAccommodationDTO accommodation = new WholeAccommodationDTO(id, "Example accommodation", "Description 1", "short description 1", "address of accommodation 1", amenities, availabilities, prices, ratings, comments, 5);
        return accommodation;
    }

    @Override
    public WholeAccommodationDTO create(WholeAccommodationDTO accommodation) throws Exception {
        return accommodation;
    }

    @Override
    public WholeAccommodationDTO update(WholeAccommodationDTO accommodation) throws Exception {
        return accommodation;
    }

    @Override
    public void delete(Long id) {
        //TODO: delete accommodation
    }

    @Override
    public ArrayList<AccommodationListingDTO> findOwnersActiveAccommodations(Long ownerId) {
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
    public ArrayList<AccommodationListingDTO> findUnapprovedAccommodations() {
        return findOwnersActiveAccommodations(2L);
    }

    @Override
    public ArrayList<FavouriteAccommodationDTO> findGuestsFavouriteAccommodations(Long guestId) throws IOException {
        WholeAccommodationDTO accommodation = findOne(1L);
        //TODO: images
        FavouriteAccommodationDTO accommodation1 = new FavouriteAccommodationDTO(1L, "Example accommodation 1", "Description 1", 80.00, 4,"Example address 1");
        FavouriteAccommodationDTO accommodation2 = new FavouriteAccommodationDTO(2L, "Example accommodation 2", "Description 2", 100.00, 5,"Example address 2");
        FavouriteAccommodationDTO accommodation3 = new FavouriteAccommodationDTO(3L, "Example accommodation 3", "Description 3", 85.50, 3.2F,"Example address 3");
        ArrayList<FavouriteAccommodationDTO> accommodations = new ArrayList<>();
        accommodations.add(accommodation1);
        accommodations.add(accommodation2);
        accommodations.add(accommodation3);
        return accommodations;

    }

    @Override
    public ArrayList<AccommodationListingDTO> search(String startDate, String endDate, String location, int people) {
        return findOwnersActiveAccommodations(2L);
    }

    @Override
    public ArrayList<AccommodationListingDTO> findAllOwnersAccommodations(Long ownerId) {
        return findOwnersActiveAccommodations(2L);
    }

    @Override
    public ArrayList<AccommodationListingDTO> applyFilters(ArrayList<AccommodationListingDTO> accommodations, Filter filter) {
        return findOwnersActiveAccommodations(2L);
    }
}