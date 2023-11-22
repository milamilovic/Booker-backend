package booker.BookingApp.model.accommodation;

import lombok.Data;

import java.util.Date;

public @Data class Availability {
    private Date startDate;
    private Date endDate;
}
