package booker.BookingApp.dto.accommodation;

import booker.BookingApp.model.accommodation.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.awt.*;
import java.util.ArrayList;

public @Data @AllArgsConstructor class WholeAccommodationDTO {
    private Long id;
    private String title;
    private String description;
    private String shortDescription;
    private String address;
    private ArrayList<Amenity> amenities;
    //private ArrayList<Image> images;
    private ArrayList<Availability> availabilities;
    private ArrayList<Price> prices;
    private ArrayList<AccommodationRating> ratings;
    private ArrayList<AccommodationComment> comments;
    private int deadline;

    public static WholeAccommodationDTO makeFromAccommodation(Accommodation accommodation) {
        //TODO: images!!!

        return new WholeAccommodationDTO(accommodation.getId(),
                accommodation.getTitle(), accommodation.getDescription(), accommodation.getShortDescription(),
                accommodation.getAddress(), accommodation.getAmenities(), accommodation.getAvailabilities(),
                accommodation.getPrices(), accommodation.getRatings(),accommodation.getComments(),
                accommodation.getDeadline());
    }
}
