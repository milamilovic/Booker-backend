package booker.BookingApp.dto.accommodation;

import booker.BookingApp.model.accommodation.Accommodation;
import lombok.AllArgsConstructor;
import lombok.Data;

public @Data @AllArgsConstructor
class FavouriteAccommodationDTO {
    Long id;
    String title;
    String shortDescription;
    //TODO: images
    //this.images = images;
    Double avgPrice;
    float avgRating;
    String address;

    public static FavouriteAccommodationDTO makeFromAccommodation(Accommodation accommodation) {

        return new FavouriteAccommodationDTO(accommodation.getId(),
                accommodation.getTitle(), accommodation.getShortDescription(),
                accommodation.getPrices().get(0).getCost(), accommodation.getRatings().get(0).getRate(),
                accommodation.getAddress());
    }

    public static FavouriteAccommodationDTO makeFromWholeAccommodation(WholeAccommodationDTO accommodation) {
        return new FavouriteAccommodationDTO(accommodation.getId(),
                accommodation.getTitle(), accommodation.getShortDescription(),
                accommodation.getPrices().get(0).getCost(), accommodation.getRatings().get(0).getRate(),
                accommodation.getAddress());
    }
}
