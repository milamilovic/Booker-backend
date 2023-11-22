package booker.BookingApp.service.implementation;

import booker.BookingApp.dto.accommodation.AccommodationListingDTO;
import booker.BookingApp.dto.accommodation.FavouriteAccommodationDTO;
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
    public ArrayList<Accommodation> findAll() throws IOException {
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
        prices.add(new Price(120, new Date(), new Date(), "price type 1"));
        prices.add(new Price(80, new Date(), new Date(), "price type 2"));
        prices.add(new Price(210, new Date(), new Date(), "price type 3"));
        prices.add(new Price(145, new Date(), new Date(), "price type 4"));
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
        Accommodation accommodation1 = new Accommodation(1L, "Example accommodation 1", "Description 1", "short description 1", "address of accommodation 1", amenities, images, availabilities, prices, ratings, comments, 5);
        Accommodation accommodation2 = new Accommodation(2L, "Example accommodation 2", "Description 2", "short description 2", "address of accommodation 2", amenities, images, availabilities, prices, ratings, comments, 5);
        Accommodation accommodation3 = new Accommodation(3L, "Example accommodation 3", "Description 3", "short description 3", "address of accommodation 3", amenities, images, availabilities, prices, ratings, comments, 5);
        ArrayList<Accommodation> accommodations = new ArrayList<>();
        accommodations.add(accommodation1);
        accommodations.add(accommodation2);
        accommodations.add(accommodation3);
        return accommodations;
    }

    @Override
    public Accommodation findOne(Long id) throws IOException {
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
        prices.add(new Price(120, new Date(), new Date(), "price type 1"));
        prices.add(new Price(80, new Date(), new Date(), "price type 2"));
        prices.add(new Price(210, new Date(), new Date(), "price type 3"));
        prices.add(new Price(145, new Date(), new Date(), "price type 4"));
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
        return new Accommodation(id, "Example accommodation", "Description 1", "short description 1", "address of accommodation 1", amenities, images, availabilities, prices, ratings, comments, 5);
    }

    @Override
    public Accommodation create(Accommodation accommodation) throws Exception {
        return accommodation;
    }

    @Override
    public Accommodation update(Accommodation accommodation) throws Exception {
        return accommodation;
    }

    @Override
    public void delete(Long id) {
        //TODO: delete accommodation
    }

    @Override
    public ArrayList<AccommodationListingDTO> findOwnersActiveAccommodations(Long ownerId) {
        try {
            AccommodationListingDTO dto = new AccommodationListingDTO();
            ArrayList<Accommodation> accommodations = findAll();
            ArrayList<AccommodationListingDTO> accommodationListingDTOS = new ArrayList<>();
            for(Accommodation a: accommodations) {
                accommodationListingDTOS.add(dto.makeFromAccommodation(a));
            }
            return accommodationListingDTOS;
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
    public ArrayList<FavouriteAccommodationDTO> findGuestsFavouriteAccommodations(Long guestId) {
        try {
            FavouriteAccommodationDTO dto = new FavouriteAccommodationDTO();
            ArrayList<Accommodation> accommodations = findAll();
            ArrayList<FavouriteAccommodationDTO> favouriteAccommodationDTOS = new ArrayList<>();
            for(Accommodation a: accommodations) {
                favouriteAccommodationDTOS.add(dto.makeFromAccommodation(a));
            }
            return favouriteAccommodationDTOS;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<AccommodationListingDTO> search(String startDate, String endDate, String location, int people) {
        return findOwnersActiveAccommodations(2L);
    }

    @Override
    public ArrayList<AccommodationListingDTO> findAllOwnersAccommodations(Long ownerId) {
        return findOwnersActiveAccommodations(2L);
    }
}
