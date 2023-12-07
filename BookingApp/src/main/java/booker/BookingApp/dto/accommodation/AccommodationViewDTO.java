package booker.BookingApp.dto.accommodation;

import booker.BookingApp.model.accommodation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

public @Data @AllArgsConstructor @NoArgsConstructor class AccommodationViewDTO {
    private Long id;
    private String title;
    private String description;
    private String address;
    private List<Amenity> amenities;
    private List<Image> images;
    private List<Availability> availabilities;
    private List<Price> prices;
    private List<AccommodationRating> ratings;
    private List<AccommodationComment> comments;

    public static AccommodationViewDTO makeFromAccommodation(Accommodation accommodation) {
        return new AccommodationViewDTO(accommodation.getId(),
                accommodation.getTitle(), accommodation.getDescription(),
                accommodation.getAddress(), accommodation.getAmenities(),
                accommodation.getImages(), accommodation.getAvailabilities(),
                accommodation.getPrices(), accommodation.getRatings(),accommodation.getComments());
    }
}
