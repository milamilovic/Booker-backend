package booker.BookingApp.service.implementation;

import booker.BookingApp.dto.business.AccommodationReportDTO;
import booker.BookingApp.dto.business.IntervalReportDTO;
import booker.BookingApp.enums.ReportType;
import booker.BookingApp.model.business.MonthReport;
import booker.BookingApp.model.business.OneAccIntervalReport;
import booker.BookingApp.service.interfaces.IReportService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class ReportService implements IReportService {
    @Override
    public IntervalReportDTO getIntervalReport(Long ownerId, String from, String to) {
        ArrayList<OneAccIntervalReport> data = new ArrayList<>();
        data.add(new OneAccIntervalReport(1L, new Date(), new Date(), 5, 312.25));
        data.add(new OneAccIntervalReport(2L, new Date(), new Date(), 2, 115.33));
        data.add(new OneAccIntervalReport(3L, new Date(), new Date(), 6, 550.00));
        data.add(new OneAccIntervalReport(4L, new Date(), new Date(), 8, 670.50));
        return new IntervalReportDTO(1L, ReportType.PERIOD_REPORT, new Date(), new Date(), data);
    }

    @Override
    public AccommodationReportDTO getAccommodationReport(Long ownerId, Long accommodationId) {
        ArrayList<MonthReport> data = new ArrayList<>();
        data.add(new MonthReport(new Date(), new Date(), 15, 1150.00));
        data.add(new MonthReport(new Date(), new Date(), 5, 481.00));
        data.add(new MonthReport(new Date(), new Date(), 7, 713.25));
        data.add(new MonthReport(new Date(), new Date(), 11, 945.99));
        return new AccommodationReportDTO(1L, ReportType.ACCOMMODATION_REPORT, new Date(), new Date(), accommodationId, data);
    }
}
