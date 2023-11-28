package booker.BookingApp.model.requestsAndReservations;

import booker.BookingApp.enums.ReservationRequestStatus;
import booker.BookingApp.enums.ReservationStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

public @Data @AllArgsConstructor @NoArgsConstructor class Reservation {
    private Long guestId;
    private Long accommodationId;
    private Long id;
    private Date fromDate;
    private Date toDate;
    private int numberOfGuests;
    private ReservationRequestStatus requestStatus;
    private ReservationStatus status;
    private boolean deleted;
    private double price;
}
