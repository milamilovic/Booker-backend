package booker.BookingApp.service.interfaces;

import booker.BookingApp.dto.requestsAndReservations.ReservationRequestDTO;
import booker.BookingApp.model.accommodation.Filter;

import java.util.ArrayList;

public interface IReservationRequestService {

    ReservationRequestDTO create(ReservationRequestDTO request);

    ReservationRequestDTO findOne(Long id);

    ArrayList<ReservationRequestDTO> findOwnersRequests(Long ownerId);

    ArrayList<ReservationRequestDTO> search(String date, String name);

    ArrayList<ReservationRequestDTO> applyFilters(ArrayList<ReservationRequestDTO> requests, Filter filter);

    ArrayList<ReservationRequestDTO> findGuestsRequests(Long guestId);

    void cancelRequest(Long userId, Long requestId);

    void acceptOrDeclineRequest(Long ownerId, Long requestId, boolean accept);
}
