package booker.BookingApp.service.implementation;

import booker.BookingApp.dto.accommodation.AvailabilityDTO;
import booker.BookingApp.model.accommodation.Availability;
import booker.BookingApp.service.interfaces.IAvailabilityService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@Service
public class AvailabilityService implements IAvailabilityService {
    @Override
    public AvailabilityDTO create(Long accommodationId, AvailabilityDTO availabilityDTO) {
        return availabilityDTO;
    }

    @Override
    public AvailabilityDTO update(Long accommodationId, AvailabilityDTO availabilityDTO) {
        return availabilityDTO;
    }

    @Override
    public ArrayList<AvailabilityDTO> findAllFreeInRange(Long accommodationId, String startDate, String endDate) throws IOException {
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
    public void markAsNotAvailable(Long accommodationId, String startDate, String endDate) {

    }
}
