package booker.BookingApp.service.interfaces;

import booker.BookingApp.dto.requestsAndReservations.ReservationRequestDTO;
import booker.BookingApp.enums.ReservationRequestStatus;
import booker.BookingApp.model.accommodation.Filter;

import java.io.IOException;
import java.util.ArrayList;

public interface IReservationRequestService {

    ReservationRequestDTO create(ReservationRequestDTO request);

    boolean checkReservationAcceptingType(Long accommodationId);

    ReservationRequestDTO findOne(Long id);

    ArrayList<ReservationRequestDTO> findOwnersRequests(Long ownerId);

    ArrayList<ReservationRequestDTO> findAccommodationRequests(Long accommodationId);

    ArrayList<ReservationRequestDTO> search(Long guestId, String dateString, String name) throws IOException;

    ArrayList<ReservationRequestDTO> searchForOwner(Long ownerId, String dateString, String name) throws IOException;

    ArrayList<ReservationRequestDTO> applyFilters(ArrayList<ReservationRequestDTO> requests, ArrayList<ReservationRequestStatus> adequateTypes);

    ArrayList<ReservationRequestDTO> findGuestsRequests(Long guestId);

    void cancelRequest(Long userId, Long requestId);

    boolean acceptOrDecline(boolean accept, ReservationRequestDTO reservationRequestDTO);

    void declineOthers(ReservationRequestDTO acceptedRequest);
}
