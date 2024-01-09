package booker.BookingApp.service.implementation;

import booker.BookingApp.dto.accommodation.AccommodationListingDTO;
import booker.BookingApp.enums.ReportType;
import booker.BookingApp.model.business.Report;
import booker.BookingApp.model.requestsAndReservations.Reservation;
import booker.BookingApp.repository.PriceRepository;
import booker.BookingApp.repository.ReservationRepository;
import booker.BookingApp.service.interfaces.IReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ReportService implements IReportService {

    @Autowired
    AccommodationService accommodationService;

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    PriceRepository priceRepository;

    @Override
    public ArrayList<Report> getIntervalReport(Long ownerId, String from, String to) {
        ArrayList<Report> data = new ArrayList<>();
        ArrayList<AccommodationListingDTO> accommodations = accommodationService.findOwnersActiveAccommodations(ownerId);

        return data;
    }

    @Override
    public ArrayList<Report> getAccommodationReport(Long ownerId, Long accommodationId, int year) throws ParseException {
        ArrayList<Report> data = new ArrayList<>();
        int month = 0;
        double profit;
        int count;
        ArrayList<Reservation> reservations = (ArrayList<Reservation>) reservationRepository.findAllForAccommodation(accommodationId);
        while(month < 12) {
            profit = 0;
            count = 0;
            Iterator<Reservation> iterator = reservations.iterator();
            while (iterator.hasNext()) {        //for each reservation of accommodation
                Reservation currentElement = iterator.next();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date currentDate = sdf.parse(currentElement.getFromDate());
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(currentDate);      //if the year is the one chosen and res is not cancelled
                if(calendar.get(Calendar.MONTH) == month) {
                    count++;
                }
                while (currentDate.before(sdf.parse(currentElement.getToDate()))) {
                    if ((calendar.get(Calendar.YEAR) == year && calendar.get(Calendar.MONTH) == month) && !currentElement.isDeleted()) {
                        profit += priceRepository.findPriceForDate(accommodationId, currentDate);        //count profit
                    }
                    //increment date by one -> get the next day
                    calendar.add(Calendar.DAY_OF_MONTH, 1);
                    currentDate = calendar.getTime();
                }
            }

            Report report = new Report(getNameOfMonth(month), profit, count*100);
            data.add(report);
            month++;
        }
        return data;
    }

    private String getNameOfMonth(int month) {
        HashMap<Integer,String> hm = new HashMap<>();
        hm.put(0, "Jan");
        hm.put(1, "Feb");
        hm.put(2, "Mar");
        hm.put(3, "Apr");
        hm.put(4, "May");
        hm.put(5, "Jun");
        hm.put(6, "Jul");
        hm.put(7, "Aug");
        hm.put(8, "Sep");
        hm.put(9, "Oct");
        hm.put(10, "Nov");
        hm.put(11, "Dec");
        return hm.get(month);
    }
}
