package booker.BookingApp.model.accommodation;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

public @Data @AllArgsConstructor class Availability {
    private Date startDate;
    private Date endDate;
}
