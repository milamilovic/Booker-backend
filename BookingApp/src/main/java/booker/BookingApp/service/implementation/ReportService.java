package booker.BookingApp.service.implementation;

import booker.BookingApp.dto.accommodation.AccommodationListingDTO;
import booker.BookingApp.enums.ReportType;
import booker.BookingApp.model.business.Report;
import booker.BookingApp.service.interfaces.IReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class ReportService implements IReportService {

    @Autowired
    AccommodationService accommodationService;
    @Override
    public ArrayList<Report> getIntervalReport(Long ownerId, String from, String to) {
        ArrayList<Report> data = new ArrayList<>();
        ArrayList<AccommodationListingDTO> accommodations = accommodationService.findOwnersActiveAccommodations(ownerId);

        return data;
    }

    @Override
    public ArrayList<Report> getAccommodationReport(Long ownerId, Long accommodationId) {
        ArrayList<Report> data = new ArrayList<>();
        ArrayList<AccommodationListingDTO> accommodations = accommodationService.findOwnersActiveAccommodations(ownerId);
        for(AccommodationListingDTO accommodation : accommodations) {
            double profit = 0;
            int count = 0;
            //for each acc add profit and num of reservations
            Report report = new Report(accommodation.getTitle(), profit, count);
            data.add(report);
        }
        return data;
    }
}
