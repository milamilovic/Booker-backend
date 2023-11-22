package booker.BookingApp.model.accommodation;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

public @Data @AllArgsConstructor class Price {
    private int cost;
    private Date fromDate;
    private Date toDate;
    //TODO: make enum types
    private String type;
}
