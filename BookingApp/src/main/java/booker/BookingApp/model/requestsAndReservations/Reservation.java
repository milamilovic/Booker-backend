package booker.BookingApp.model.requestsAndReservations;

import booker.BookingApp.enums.ReservationRequestStatus;
import booker.BookingApp.enums.ReservationStatus;
import booker.BookingApp.model.accommodation.Accommodation;
import booker.BookingApp.model.users.Guest;
import booker.BookingApp.model.users.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
public @Data @AllArgsConstructor @NoArgsConstructor class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "guest_id")
    private Long guestId;
    @Column(name = "accommodation_id")
    private Long accommodationId;
    @Column(name = "from_date", nullable = false)
    private String fromDate;
    @Column(name = "to_date", nullable = false)
    private String toDate;
    @Column(name = "number_of_guests", nullable = false)
    private int numberOfGuests;
    @Enumerated(EnumType.STRING)
    @Column(name = "request_status", nullable = false)
    private ReservationRequestStatus requestStatus;
    @Enumerated(EnumType.STRING)
    @Column(name="reservation_status", nullable = false)
    private ReservationStatus status;
    @Column(name="deleted", nullable = false)
    private boolean deleted;
    @Column(name = "price", nullable = false)
    private double price;
}
