package booker.BookingApp.dto.accommodation;

import booker.BookingApp.model.accommodation.Accommodation;
import booker.BookingApp.model.accommodation.AccommodationRating;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.awt.*;

public @Data @AllArgsConstructor class AccommodationListingDTO {
    private Long id;
    private String title;
    private String description;
    //private Image image;
    private float rating;
    private double totalPrice;
    private double pricePerDay;

    public static AccommodationListingDTO makeFromAccommodation(Accommodation accommodation) {

        //TODO make getAverageRating, getTotalPrice and getPricePerDay methods in service

        return new AccommodationListingDTO(accommodation.getId(),
                accommodation.getTitle(), accommodation.getShortDescription(), accommodation.getRatings().get(0).getRate(),
                accommodation.getPrices().get(0).getCost(), accommodation.getPrices().get(0).getCost());
    }

    public static AccommodationListingDTO makeFromWholeAccommodation(WholeAccommodationDTO accommodation) {

        return new AccommodationListingDTO(accommodation.getId(),
                accommodation.getTitle(), accommodation.getShortDescription(), accommodation.getRatings().get(0).getRate(),
                accommodation.getPrices().get(0).getCost(), accommodation.getPrices().get(0).getCost());
    }
}
