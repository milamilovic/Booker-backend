package booker.BookingApp.dto.business;

import booker.BookingApp.enums.ReportType;
import booker.BookingApp.model.business.OneAccIntervalReport;
import booker.BookingApp.model.business.Report;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;

public @AllArgsConstructor @Data class IntervalReportDTO {
    Long id;
    ReportType type;
    Date fromDate;
    Date toDate;
    ArrayList<OneAccIntervalReport> accommodations;

    public static IntervalReportDTO makeFromReport(Report report){
        IntervalReportDTO reportDTO = new IntervalReportDTO(
                report.getId(),
                report.getType(),
                report.getFromDate(),
                report.getToDate(),
                report.getAccommodations()
        );
        return reportDTO;
    }
}
