package booker.BookingApp.dto.accommodation;

import booker.BookingApp.model.accommodation.*;
import lombok.Data;

import java.awt.*;
import java.util.ArrayList;

public @Data class AccommodationDTO {
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


    // Default constructor
    public AccommodationDTO() {
        // Initialize ArrayLists to avoid null references
        this.amenities = new ArrayList<>();
        //this.images = new ArrayList<>();
        this.availabilities = new ArrayList<>();
        this.prices = new ArrayList<>();
        this.ratings = new ArrayList<>();
        this.comments = new ArrayList<>();
    }

    // All parameters constructor
    public AccommodationDTO(Long id, String title, String description, String shortDescription, String address,
                            ArrayList<Amenity> amenities,
                            ArrayList<Availability> availabilities, ArrayList<Price> prices,
                            ArrayList<AccommodationRating> ratings, ArrayList<AccommodationComment> comments,
                            int deadline) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.shortDescription = shortDescription;
        this.address = address;
        this.amenities = amenities;
        //TODO: images
        //this.images = images;
        this.availabilities = availabilities;
        this.prices = prices;
        this.ratings = ratings;
        this.comments = comments;
        this.deadline = deadline;
    }

    //constructor for accommodation listing dto
    public AccommodationDTO(String title,
                            String shortDescription,
                            ArrayList<Price> prices,
                            ArrayList<AccommodationRating> ratings) {
        this.id = id;
        this.title = title;
        this.shortDescription = shortDescription;
        //TODO: images
        //this.images = images;
        this.prices = prices;
        this.ratings = ratings;
    }

    //constructor for accommodation listing dto
    public AccommodationDTO(String title,
                            String shortDescription,
                            ArrayList<Price> prices,
                            ArrayList<AccommodationRating> ratings,
                            String address) {
        this.id = id;
        this.title = title;
        this.shortDescription = shortDescription;
        //TODO: images
        //this.images = images;
        this.prices = prices;
        this.ratings = ratings;
        this.address = address;
    }
}
