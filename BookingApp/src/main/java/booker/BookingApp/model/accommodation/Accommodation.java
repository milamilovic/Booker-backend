package booker.BookingApp.model.accommodation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;
import java.util.ArrayList;

public @Data @AllArgsConstructor class Accommodation {
    private Long id;
    private String title;
    private String description;
    private String shortDescription;
    private String address;
    private ArrayList<Amenity> amenities;
    private ArrayList<Image> images;
    private ArrayList<Availability> availabilities;
    private ArrayList<Price> prices;
    private ArrayList<AccommodationRating> ratings;
    private ArrayList<AccommodationComment> comments;
    private int deadline;
}
