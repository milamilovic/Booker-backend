package booker.BookingApp.service.interfaces;

import booker.BookingApp.dto.requestsAndReservations.ReservationDTO;
import booker.BookingApp.dto.requestsAndReservations.ReservationRequestDTO;

import java.util.ArrayList;

public interface IReservationService {
    ArrayList<ReservationDTO> findAll();

    ArrayList<ReservationDTO> getAllForGuest(Long guestId);

    ArrayList<ReservationDTO> getAllForAccommodation(Long accommodationId);

    ReservationDTO getOneById(Long id);

    void create(ReservationRequestDTO reservationRequest);

    void delete(Long id);

    void cancel(Long guestId, Long reservationId);
}
