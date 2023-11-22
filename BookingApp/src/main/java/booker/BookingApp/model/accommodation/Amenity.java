package booker.BookingApp.model.accommodation;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.awt.*;

public @Data @AllArgsConstructor
class Amenity {
    private Long id;
    private String name;
    private Image image;
}
