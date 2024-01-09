package booker.BookingApp.model.business;

import lombok.AllArgsConstructor;
import lombok.Data;

public @Data @AllArgsConstructor class Report {
    String name;
    double profit;
    int reservations;
}
