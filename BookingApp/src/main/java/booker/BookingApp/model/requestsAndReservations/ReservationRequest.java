package booker.BookingApp.model.requestsAndReservations;

import booker.BookingApp.enums.ReservationRequestStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity @AllArgsConstructor @NoArgsConstructor
public @Data class ReservationRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JoinColumn(name = "guest_id")
    private Long guestId;
    @JoinColumn(name = "accommodation_id")
    private Long accommodationId;
    @JoinColumn(name = "from_date")
    private String fromDate;
    @JoinColumn(name = "to_date")
    private String toDate;
    @JoinColumn(name = "number_of_guests")
    private int numberOfGuests;
    @JoinColumn(name = "status")
    private ReservationRequestStatus status;
    @JoinColumn(name = "deleted")
    private boolean deleted;
    @JoinColumn(name = "price")
    private double price;
}
