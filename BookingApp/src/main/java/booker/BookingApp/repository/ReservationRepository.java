package booker.BookingApp.repository;

import booker.BookingApp.model.requestsAndReservations.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    @Query("SELECT r FROM Reservation r WHERE r.guest.id = ?1 AND r.accommodation.owner_id = ?2 AND r.status != 'CANCELED'")
    public List<Reservation> findAllForGuest(Long guestId, Long ownerId);
}
