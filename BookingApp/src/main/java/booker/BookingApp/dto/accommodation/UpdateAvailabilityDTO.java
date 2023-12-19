package booker.BookingApp.dto.accommodation;

import booker.BookingApp.enums.PriceType;
import booker.BookingApp.model.accommodation.Accommodation;
import booker.BookingApp.model.accommodation.Availability;
import lombok.Data;

import java.util.Date;

@Data
public class UpdateAvailabilityDTO {
    public Date startDate;
    public Date endDate;
    public double amount;
    public PriceType price_type;
    public int deadline;

}
