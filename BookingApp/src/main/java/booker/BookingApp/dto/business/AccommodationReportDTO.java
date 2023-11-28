package booker.BookingApp.dto.business;

import booker.BookingApp.enums.ReportType;
import booker.BookingApp.model.business.MonthReport;
import booker.BookingApp.model.business.Report;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;

public @Data @AllArgsConstructor class AccommodationReportDTO {
    Long id;
    ReportType type;
    Date fromDate;
    Date toDate;
    Long accommodation;
    ArrayList<MonthReport> monthlyReports;

    public static AccommodationReportDTO makeFromReport(Report report){
        AccommodationReportDTO reportDTO = new AccommodationReportDTO(
                report.getId(),
                report.getType(),
                report.getFromDate(),
                report.getToDate(),
                report.getAccommodation(),
                report.getMonthlyReports()
        );
        return reportDTO;
    }
}
