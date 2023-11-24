package booker.BookingApp.dto.accommodation;

import lombok.Data;

import javax.swing.*;
import java.awt.*;

public @Data class AmenityDTO {
    private Long id;
    private String name;
    private Image image;

    // Default constructor
    public AmenityDTO() {
        // Initialize Image to avoid null references
        this.image = new ImageIcon().getImage();
    }

    // Parameterized constructor
    public AmenityDTO(Long id, String name, Image image) {
        this.id = id;
        this.name = name;
        this.image = image;
    }
}
