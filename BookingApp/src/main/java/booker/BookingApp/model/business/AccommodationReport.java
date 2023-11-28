package booker.BookingApp.model.business;

import lombok.Data;

import java.util.ArrayList;

public @Data class AccommodationReport extends Report{
    Long accommodation;
    ArrayList<MonthReport> monthlyReports;
}
