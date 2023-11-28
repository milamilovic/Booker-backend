package booker.BookingApp.model.requestsAndReservations;

import booker.BookingApp.enums.ReservationRequestStatus;
import lombok.Data;

import java.util.Date;

public @Data class ReservationRequest {
    private Date fromDate;
    private Date toDate;
    private int numberOfGuests;
    private ReservationRequestStatus status;
    private boolean deleted;
}
