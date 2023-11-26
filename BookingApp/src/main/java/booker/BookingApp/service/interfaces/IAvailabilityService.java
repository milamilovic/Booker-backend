package booker.BookingApp.service.interfaces;

import booker.BookingApp.dto.accommodation.AmenityDTO;
import booker.BookingApp.dto.accommodation.AvailabilityDTO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public interface IAvailabilityService {
    AvailabilityDTO create(Long accommodationId, AvailabilityDTO availabilityDTO);

    AvailabilityDTO update(Long accommodationId, AvailabilityDTO availabilityDTO);

    ArrayList<AvailabilityDTO> findAllFreeInRange(Long accommodationId, Date startDate, Date endDate) throws IOException;

    boolean checkForDate(Long accommodationId, Date date);

    void markAsNotAvailable(Long accommodationId, Date startDate, Date endDate);
}
