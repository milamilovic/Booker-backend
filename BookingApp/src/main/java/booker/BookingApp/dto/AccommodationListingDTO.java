package booker.BookingApp.dto;

import booker.BookingApp.model.accommodation.Accommodation;
import booker.BookingApp.model.accommodation.AccommodationRating;
import lombok.Data;

public @Data class AccommodationListingDTO {
    private Long id;
    private String title;
    private String description;
    private int image;
    private AccommodationRating rating;

    public AccommodationListingDTO makeFromAccommodation(Accommodation accommodation) {
        AccommodationListingDTO listingDTO = new AccommodationListingDTO();
        listingDTO.id = accommodation.getId();
        listingDTO.title = accommodation.getTitle();
        listingDTO.description = accommodation.getShortDescription();
        listingDTO.image =accommodation.getImages().get(0);
        //TODO make getAverageRating function in service
        listingDTO.rating = accommodation.getRatings().get(0);
        return listingDTO;
    }
}
