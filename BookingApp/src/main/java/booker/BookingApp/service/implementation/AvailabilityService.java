package booker.BookingApp.service.implementation;

import booker.BookingApp.dto.accommodation.AvailabilityDTO;
import booker.BookingApp.model.accommodation.Availability;
import booker.BookingApp.repository.AvailabilityRepository;
import booker.BookingApp.service.interfaces.IAvailabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@Service
public class AvailabilityService implements IAvailabilityService {

    @Autowired
    AvailabilityRepository repository;
    @Override
    public AvailabilityDTO create(Long accommodationId, AvailabilityDTO availabilityDTO) {
        return availabilityDTO;
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
    public boolean checkForDate(Long accommodationId, String date) {
        return true;
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
