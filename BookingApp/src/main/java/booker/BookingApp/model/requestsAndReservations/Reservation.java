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
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "guest_id")
    private User guest;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "accommodation_id")
    private Accommodation accommodation;
    @Column(name = "from_date", nullable = false)
    private Date fromDate;
    @Column(name = "to_date", nullable = false)
    private Date toDate;
    @Column(name = "guests_number", nullable = false)
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
