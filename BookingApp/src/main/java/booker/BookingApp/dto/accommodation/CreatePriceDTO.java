package booker.BookingApp.dto.accommodation;

import booker.BookingApp.enums.PriceType;
import booker.BookingApp.model.accommodation.Price;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

public @Data class CreatePriceDTO {
    private double cost;
    private Date fromDate;
    private Date toDate;
    private PriceType type;

    public CreatePriceDTO() {
    }

    public CreatePriceDTO(Price price) {
        this(price.getCost(), price.getFromDate(), price.getToDate(), price.getType());
    }

    public CreatePriceDTO( double cost, Date fromDate, Date toDate, PriceType type) {
        this.cost = cost;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.type = type;
    }
}
