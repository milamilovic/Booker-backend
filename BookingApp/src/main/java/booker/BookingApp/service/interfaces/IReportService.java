package booker.BookingApp.service.interfaces;
import booker.BookingApp.model.business.Report;

import java.util.ArrayList;
import java.util.Date;

public interface IReportService {
    ArrayList<Report> getIntervalReport(Long ownerId, String from, String to);

    ArrayList<Report> getAccommodationReport(Long ownerId, Long accommodationId);
}
