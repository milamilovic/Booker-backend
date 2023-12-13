package booker.BookingApp.dto.accommodation;

import booker.BookingApp.model.accommodation.Accommodation;
import booker.BookingApp.model.accommodation.Image;
import booker.BookingApp.service.implementation.AccommodationService;
import lombok.AllArgsConstructor;
import lombok.Data;

public @Data @AllArgsConstructor class AccommodationListingDTO {
    private Long id;
    private String title;
    private String description;
    private Image image;        //path to image in front
    private float rating;
    private double totalPrice;
    private double pricePerDay;

    public static AccommodationListingDTO makeFromAccommodation(Accommodation accommodation) {

        //TODO make getAverageRating

        return new AccommodationListingDTO(accommodation.getId(),
                accommodation.getTitle(), accommodation.getShortDescription(),
                accommodation.getImages().get(0), 4.3f,
                0d, 0d);
    }

}
