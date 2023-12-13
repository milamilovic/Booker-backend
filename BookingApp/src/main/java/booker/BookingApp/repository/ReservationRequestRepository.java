package booker.BookingApp.repository;

import booker.BookingApp.model.requestsAndReservations.ReservationRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRequestRepository extends JpaRepository<ReservationRequest, Long> {
}
