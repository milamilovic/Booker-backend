package booker.BookingApp.service.implementation;

import booker.BookingApp.dto.accommodation.AccommodationListingDTO;
import booker.BookingApp.dto.accommodation.FavouriteAccommodationDTO;
import booker.BookingApp.dto.accommodation.WholeAccommodationDTO;
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
    public ArrayList<WholeAccommodationDTO> findAll() throws IOException {
        WholeAccommodationDTO accommodation = findOne(1L);
        Accommodation accommodation1 = new Accommodation(1L, "Example accommodation 1", "Description 1", "short description 1", "address of accommodation 1", accommodation.getAmenities(), accommodation.getImages(), accommodation.getAvailabilities(), accommodation.getPrices(), accommodation.getRatings(), accommodation.getComments(), 5);
        Accommodation accommodation2 = new Accommodation(2L, "Example accommodation 2", "Description 2", "short description 2", "address of accommodation 2", accommodation.getAmenities(), accommodation.getImages(), accommodation.getAvailabilities(), accommodation.getPrices(), accommodation.getRatings(), accommodation.getComments(), 5);
        Accommodation accommodation3 = new Accommodation(3L, "Example accommodation 3", "Description 3", "short description 3", "address of accommodation 3", accommodation.getAmenities(), accommodation.getImages(), accommodation.getAvailabilities(), accommodation.getPrices(), accommodation.getRatings(), accommodation.getComments(), 5);
        ArrayList<WholeAccommodationDTO> accommodations = new ArrayList<>();
        accommodations.add(WholeAccommodationDTO.makeFromAccommodation(accommodation1));
        accommodations.add(WholeAccommodationDTO.makeFromAccommodation(accommodation2));
        accommodations.add(WholeAccommodationDTO.makeFromAccommodation(accommodation3));
        return accommodations;
    }

    @Override
    public WholeAccommodationDTO findOne(Long id) throws IOException {
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
        Accommodation accommodation = new Accommodation(id, "Example accommodation", "Description 1", "short description 1", "address of accommodation 1", amenities, images, availabilities, prices, ratings, comments, 5);
        return WholeAccommodationDTO.makeFromAccommodation(accommodation);
    }

    @Override
    public WholeAccommodationDTO create(Accommodation accommodation) throws Exception {
        return WholeAccommodationDTO.makeFromAccommodation(accommodation);
    }

    @Override
    public WholeAccommodationDTO update(Accommodation accommodation) throws Exception {
        return WholeAccommodationDTO.makeFromAccommodation(accommodation);
    }

    @Override
    public void delete(Long id) {
        //TODO: delete accommodation
    }

    @Override
    public ArrayList<AccommodationListingDTO> findOwnersActiveAccommodations(Long ownerId) {
        try {

            ArrayList<WholeAccommodationDTO> accommodations = findAll();
            ArrayList<AccommodationListingDTO> accommodationListingDTOS = new ArrayList<>();
            for(WholeAccommodationDTO a: accommodations) {
                accommodationListingDTOS.add(AccommodationListingDTO.makeFromWholeAccommodation(a));
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
            ArrayList<WholeAccommodationDTO> accommodations = findAll();
            ArrayList<FavouriteAccommodationDTO> favouriteAccommodationDTOS = new ArrayList<>();
            for(WholeAccommodationDTO a: accommodations) {
                favouriteAccommodationDTOS.add(FavouriteAccommodationDTO.makeFromWholeAccommodation(a));
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

    @Override
    public ArrayList<AccommodationListingDTO> applyFilters(ArrayList<AccommodationListingDTO> accommodations, Filter filter) {
        return findOwnersActiveAccommodations(2L);
    }
}
