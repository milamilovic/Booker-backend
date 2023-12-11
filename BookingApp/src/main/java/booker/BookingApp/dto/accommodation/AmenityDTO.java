package booker.BookingApp.dto.accommodation;

import booker.BookingApp.enums.AccommodationType;
import booker.BookingApp.model.accommodation.Accommodation;
import booker.BookingApp.model.accommodation.Amenity;
import booker.BookingApp.model.accommodation.Image;
import lombok.Data;

import javax.swing.*;

public @Data class AmenityDTO {
    private Long id;
    private String name;
    private String image_path;

    // Parameterized constructor
    public AmenityDTO(Long id, String name, String image) {
        this.id = id;
        this.name = name;
        this.image_path = image;
    }

    public static AmenityDTO makeFromAmenity(Amenity amenity) {
        return new AmenityDTO(amenity.getId(), amenity.getName(), amenity.getImage_path());
    }

    public Amenity toAmenity(Accommodation accommodation){
        Amenity amenity = new Amenity();
        amenity.setName(name);
        amenity.setAccommodation(accommodation);
        return amenity;
    }
}
