package booker.BookingApp.service.interfaces;

import booker.BookingApp.dto.business.AccommodationReportDTO;
import booker.BookingApp.dto.business.IntervalReportDTO;

import java.util.Date;

public interface IReportService {
    IntervalReportDTO getIntervalReport(Long ownerId, String from, String to);

    AccommodationReportDTO getAccommodationReport(Long ownerId, Long accommodationId);
}
