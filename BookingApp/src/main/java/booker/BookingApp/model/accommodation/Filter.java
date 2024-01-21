package booker.BookingApp.model.accommodation;

import lombok.Data;

public @Data class Filter {
    //priceMin: 100, ac: True, type: Enum.hotel   ->   examples of different filters
    String name;
    Object value;
}
