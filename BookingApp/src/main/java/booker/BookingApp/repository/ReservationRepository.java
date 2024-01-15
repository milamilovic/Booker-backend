package booker.BookingApp.repository;

import booker.BookingApp.model.requestsAndReservations.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    // TODO change accommodation_id

    @Query("SELECT r FROM Reservation r " +
            "WHERE r.guestId = ?1 " +
            "AND r.accommodation.owner_id = ?2 " +
            "AND r.status != 'CANCELED'" +
            "AND PARSEDATETIME(FORMATDATETIME(r.toDate, 'yyyy-MM-dd'), 'yyyy-MM-dd') < CURRENT_DATE")

    public List<Reservation> findAllForGuest(Long guestId, Long ownerId);

    @Query(value="select r from Reservation r where r.accommodation.id=:accommodationId")
    public List<Reservation> findAllForAccommodation(@Param("accommodationId") Long accommodationId);

    @Query(value = "SELECT r FROM Reservation r WHERE r.guestId = :id")
    public List<Reservation> getAllForGuest(@Param("id") Long id);

    @Query(value = "SELECT r FROM Reservation r WHERE r.accommodation.id = :id")
    public List<Reservation> getAllForAccommodation(@Param("id") Long id);
}
