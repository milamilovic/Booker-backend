package booker.BookingApp.dto.accommodation;

import booker.BookingApp.enums.PriceType;
import booker.BookingApp.model.accommodation.Price;
import lombok.Data;

import java.util.Date;

public @Data class CreatePriceDTO {
    private Long accommodation_id;
    private double cost;
    private Date fromDate;
    private Date toDate;
    private PriceType type;

    public CreatePriceDTO() {
    }

    public CreatePriceDTO(Price price) {
        this(price.getAccommodation().getId(), price.getCost(), price.getFromDate(), price.getToDate(), price.getType());
    }

    public CreatePriceDTO(Long accommodation_id, double cost, Date fromDate, Date toDate, PriceType type) {
        this.accommodation_id = accommodation_id;
        this.cost = cost;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.type = type;
    }
}
