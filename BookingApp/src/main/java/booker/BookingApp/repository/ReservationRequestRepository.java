package booker.BookingApp.repository;

import booker.BookingApp.model.requestsAndReservations.ReservationRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ReservationRequestRepository extends JpaRepository<ReservationRequest, Long> {

    @Query(value = "SELECT r FROM ReservationRequest r WHERE r.accommodationId IN :accommodationIds")
    List<ReservationRequest> findAllForOwner(@Param("accommodationIds") List<Long> accommodationIds);

    @Query(value = "SELECT r FROM ReservationRequest r WHERE r.accommodationId = :accommodationId")
    List<ReservationRequest> findAllForAccommodation(@Param("accommodationId") Long accommodationId);

    @Query(value = "SELECT r FROM ReservationRequest r WHERE r.guestId = :guestId")
    List<ReservationRequest> findAllForGuest(@Param("guestId") Long guestId);
}
