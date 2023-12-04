package booker.BookingApp.dto.accommodation;

import booker.BookingApp.model.accommodation.Accommodation;
import booker.BookingApp.model.accommodation.Image;
import lombok.Data;

import javax.swing.*;

public @Data class AmenityDTO {
    private Long id;
    private String name;
    private Image image;

    // Parameterized constructor
    public AmenityDTO(Long id, String name, Image image) {
        this.id = id;
        this.name = name;
        this.image = image;
    }
}
