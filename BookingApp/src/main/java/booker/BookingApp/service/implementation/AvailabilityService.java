package booker.BookingApp.service.implementation;

import booker.BookingApp.dto.accommodation.AccommodationViewDTO;
import booker.BookingApp.dto.accommodation.AvailabilityDTO;
import booker.BookingApp.dto.requestsAndReservations.ReservationRequestDTO;
import booker.BookingApp.model.accommodation.Accommodation;
import booker.BookingApp.model.accommodation.Availability;
import booker.BookingApp.repository.AccommodationRepository;
import booker.BookingApp.repository.AvailabilityRepository;
import booker.BookingApp.service.interfaces.IAvailabilityService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class AvailabilityService implements IAvailabilityService {

    @Autowired
    AvailabilityRepository repository;
    @Autowired
    AccommodationRepository accommodationRepository;

    @Override
    public Availability create(Long accommodationId, AvailabilityDTO availabilityDTO) {
        Availability availability = new Availability();
        Accommodation accommodation = accommodationRepository.findById(accommodationId).orElseGet(null);
        if (accommodation == null) {
            return null;
        }
        availability.setAccommodation(accommodation);
        availability.setStartDate(availabilityDTO.getStartDate());
        availability.setEndDate(availabilityDTO.getStartDate());
        repository.save(availability);
        return availability;
    }

    @Override
    public AvailabilityDTO update(Long accommodationId, AvailabilityDTO availabilityDTO) {

        return availabilityDTO;
    }

    @Override
    public ArrayList<AvailabilityDTO> findAllFreeInRange(Long accommodationId,
                                                         String startDate,
                                                         String endDate) throws IOException {
        ArrayList<AvailabilityDTO> availabilities = new ArrayList<>();
        availabilities.add(new AvailabilityDTO(new Date(), new Date()));
        availabilities.add(new AvailabilityDTO(new Date(), new Date()));
        availabilities.add(new AvailabilityDTO(new Date(), new Date()));
        availabilities.add(new AvailabilityDTO(new Date(), new Date()));
        return availabilities;
    }

    @Override
    public boolean checkForDate(Long accommodationId, String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
        Date date1 = sdf.parse(date);
        boolean freeForRange = repository.checkForDate(accommodationId, date1) != null;
        System.out.println(date + " is " + freeForRange);
        //if it finds something than it's free for that day and should return true
        return freeForRange;
    }

    @Override
    public boolean checkForDateRange(Long accommodationId, Date startDate, Date endDate) {
        //if empty than it's not free in range and should return false
        return !repository.checkForDateRange(accommodationId, startDate, endDate).isEmpty();
    }

    @Override
    public void markAsNotAvailable(Long accommodationId, String startDate, String endDate) {

    }

    public Date daysCalculator(Date date, int days){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, days);
        return calendar.getTime();
    }

    @Override
    public void refactorAvailability(Availability availability, Date fromDate, Date toDate) {
        Instant availabilityStart = availability.getStartDate().toInstant();
        Instant availabilityEnd = availability.getEndDate().toInstant();
        Instant startDate = fromDate.toInstant();
        Instant endDate = toDate.toInstant();
        if (availabilityStart.equals(startDate) && availabilityEnd.equals(endDate)) {
            // obrisi ceo availability
            repository.delete(availability);
        } else if (availabilityStart.equals(startDate) && availabilityEnd.isAfter(endDate)) {
            // izmeni availability tako da pocinje sa endDate a zavrsava se isto kao pre
            availability.setStartDate(toDate);
            repository.save(availability);
        } else if (availabilityStart.isBefore(startDate) && availabilityEnd.equals(endDate)) {
            // izmeni da pocinje sa istim a zavrsava se sa startDate-1
            availability.setEndDate(daysCalculator(fromDate, -1));
            repository.save(availability);
        } else if (availabilityStart.isBefore(startDate) && availabilityEnd.isAfter(endDate)) {
            // trenutni izmnei da pocne sa istim a zavrsava se sa startDate-1 i napravi novi koji
            // pocne sa endDate a zavrsi se sa istim
            Date oldEndDate = availability.getEndDate();
            availability.setEndDate(daysCalculator(fromDate, -1));
            repository.save(availability);
            Availability newAvailability = new Availability();
            newAvailability.setStartDate(toDate);
            newAvailability.setEndDate(oldEndDate);
            newAvailability.setAccommodation(availability.getAccommodation());
            repository.save(newAvailability);
        }

    }

    @Override
    public boolean checkForOverlaps(ReservationRequestDTO requestDTO, ReservationRequestDTO acceptedRequest) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date startA = sdf.parse(requestDTO.getFromDate());
            Date endA = sdf.parse(requestDTO.getToDate());
            Date startB = sdf.parse(acceptedRequest.getFromDate());
            Date endB = sdf.parse(acceptedRequest.getToDate());
            // return true if overlap
            return (endA.after(startB) && endA.before(endB)) || (startA.after(startB) && startA.before(endB));
        } catch (ParseException e) {
            System.out.println(e);
            return false;
        }
    }

}
