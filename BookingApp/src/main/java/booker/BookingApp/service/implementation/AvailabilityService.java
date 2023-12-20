package booker.BookingApp.service.implementation;

import booker.BookingApp.dto.accommodation.AvailabilityDTO;
import booker.BookingApp.model.accommodation.Accommodation;
import booker.BookingApp.model.accommodation.Availability;
import booker.BookingApp.repository.AccommodationRepository;
import booker.BookingApp.repository.AvailabilityRepository;
import booker.BookingApp.service.interfaces.IAvailabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
}
