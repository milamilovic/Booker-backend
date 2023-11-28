package booker.BookingApp.model.business;

import lombok.Data;

import java.util.ArrayList;

public @Data class DateIntervalReport extends Report {
    ArrayList<OneAccIntervalReport> accommodations;
}
