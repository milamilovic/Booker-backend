package booker.BookingApp.dto.accommodation;

import booker.BookingApp.model.accommodation.Accommodation;
import booker.BookingApp.model.accommodation.Image;
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

        //TODO make getAverageRating, getTotalPrice and getPricePerDay methods in service


        return new AccommodationListingDTO(accommodation.getId(),
                accommodation.getTitle(), accommodation.getShortDescription(),
                null, 4.3f,
                12d, 3d);
    }

}
