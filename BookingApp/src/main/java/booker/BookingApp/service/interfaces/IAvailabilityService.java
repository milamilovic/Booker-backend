package booker.BookingApp.service.interfaces;

import booker.BookingApp.dto.accommodation.AmenityDTO;
import booker.BookingApp.dto.accommodation.AvailabilityDTO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public interface IAvailabilityService {
    AvailabilityDTO create(Long accommodationId, AvailabilityDTO availabilityDTO);

    AvailabilityDTO update(Long accommodationId, AvailabilityDTO availabilityDTO);

    ArrayList<AvailabilityDTO> findAllFreeInRange(Long accommodationId, String startDate, String endDate) throws IOException;

    boolean checkForDate(Long accommodationId, String date);

    boolean checkForDateRange(Long accommodationId, Date startDate, Date endDate);

    void markAsNotAvailable(Long accommodationId, String startDate, String endDate);
}
