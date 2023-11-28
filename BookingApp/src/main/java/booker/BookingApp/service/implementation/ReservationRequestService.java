package booker.BookingApp.service.implementation;

import booker.BookingApp.dto.requestsAndReservations.ReservationRequestDTO;
import booker.BookingApp.enums.ReservationRequestStatus;
import booker.BookingApp.model.accommodation.Filter;
import booker.BookingApp.service.interfaces.IReservationRequestService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class ReservationRequestService implements IReservationRequestService {
    @Override
    public ReservationRequestDTO create(ReservationRequestDTO request) {
        return request;
    }

    @Override
    public ReservationRequestDTO findOne(Long id) {
        return new ReservationRequestDTO(id, 1L, 1L, new Date(), new Date(), 2, ReservationRequestStatus.WAITING, false, 150.5);
    }

    @Override
    public ArrayList<ReservationRequestDTO> findOwnersRequests(Long ownerId) {
        ArrayList<ReservationRequestDTO> requestDTOS = new ArrayList<>();
        requestDTOS.add(findOne(1L));
        requestDTOS.add(findOne(2L));
        requestDTOS.add(findOne(3L));
        return requestDTOS;
    }

    @Override
    public ArrayList<ReservationRequestDTO> search(String date, String name) {
        return findOwnersRequests(1L);
    }

    @Override
    public ArrayList<ReservationRequestDTO> applyFilters(ArrayList<ReservationRequestDTO> requests, Filter filter) {
        return findOwnersRequests(1L);
    }

    @Override
    public ArrayList<ReservationRequestDTO> findGuestsRequests(Long guestId) {
        return findOwnersRequests(1L);
    }

    @Override
    public void cancelRequest(Long userId, Long requestId) {

    }

    @Override
    public void acceptOrDeclineRequest(Long ownerId, Long requestId, boolean accept) {

    }
}
