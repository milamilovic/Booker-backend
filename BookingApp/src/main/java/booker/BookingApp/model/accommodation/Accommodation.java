package booker.BookingApp.model.accommodation;

import lombok.Data;

import java.util.ArrayList;

public @Data class Accommodation {
    private Long id;
    private String title;
    private String description;
    private String shortDescription;
    private String address;
    private ArrayList<Amenity> amenities;
    private ArrayList<Integer> images;
    private boolean favourite;
    private ArrayList<Availability> availabilities;
    private ArrayList<Price> prices;
    private ArrayList<AccommodationRating> ratings;
    private ArrayList<AccommodationComment> comments;
    private int deadline;
}
