package booker.BookingApp.model.business;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

public @Data @AllArgsConstructor class MonthReport {
    Date startDate;
    Date endDate;
    int numberOfReservations;
    double profit;
}
