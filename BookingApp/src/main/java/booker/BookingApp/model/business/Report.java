package booker.BookingApp.model.business;

import booker.BookingApp.enums.ReportType;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;

public @Data class Report {
    Long id;
    ReportType type;
    Date fromDate;
    Date toDate;
    Long accommodation;
    ArrayList<MonthReport> monthlyReports;              //for one acc report
    ArrayList<OneAccIntervalReport> accommodations;     //for date interval report
}
