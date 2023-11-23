package booker.BookingApp.dto;

import booker.BookingApp.enums.PriceType;
import booker.BookingApp.model.accommodation.Price;
import lombok.Data;

import java.util.Date;

public @Data class PriceDTO {
    private Long id;
    private Long accommodationId;
    private double cost;
    private Date fromDate;
    private Date toDate;
    private PriceType priceType;

    public PriceDTO() {
    }

    public PriceDTO(Price price) {
        this(price.getId(), price.getAccommodationId(), price.getCost(), price.getFromDate(), price.getToDate(), price.getType());
    }

    public PriceDTO(Long id, Long accommodationId, double cost, Date fromDate, Date toDate, PriceType priceType) {
        this.id = id;
        this.accommodationId = accommodationId;
        this.cost = cost;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.priceType = priceType;
    }
}
