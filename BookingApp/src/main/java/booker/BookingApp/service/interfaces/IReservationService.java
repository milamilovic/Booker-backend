package booker.BookingApp.service.interfaces;

import booker.BookingApp.dto.requestsAndReservations.ReservationDTO;

import java.util.ArrayList;

public interface IReservationService {
    ArrayList<ReservationDTO> findAll();
    ArrayList<ReservationDTO> getAllForGuest(Long guestId);
    ArrayList<ReservationDTO> getAllForAccommodation(Long accommodationId);
    ReservationDTO getOneById(Long id);
    ReservationDTO create(ReservationDTO reservation);
    void delete(Long id);
}
