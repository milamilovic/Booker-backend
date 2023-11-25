package booker.BookingApp.dto.accommodation;

import booker.BookingApp.enums.PriceType;
import booker.BookingApp.model.accommodation.Price;
import lombok.Data;

import java.util.Date;

public @Data class PriceDTO {
    private Long id;
    //private Long accommodationId;
    private double cost;
    private Date fromDate;
    private Date toDate;
    private PriceType priceType;

    public PriceDTO() {
    }

    public PriceDTO(Price price) {
        this(price.getId(), price.getCost(), price.getFromDate(), price.getToDate(), price.getType());
    }

    public PriceDTO(Long id, double cost, Date fromDate, Date toDate, PriceType priceType) {
        this.id = id;
        this.cost = cost;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.priceType = priceType;
    }
}
