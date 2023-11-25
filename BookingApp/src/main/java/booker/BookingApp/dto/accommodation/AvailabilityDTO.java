package booker.BookingApp.dto.accommodation;

import lombok.Data;

import java.util.Date;

public @Data class AvailabilityDTO {
    private Date startDate;
    private Date endDate;

    public AvailabilityDTO(Date startDate, Date endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
