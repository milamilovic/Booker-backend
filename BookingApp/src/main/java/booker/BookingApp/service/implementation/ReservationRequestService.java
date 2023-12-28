package booker.BookingApp.service.implementation;

import booker.BookingApp.dto.accommodation.AccommodationViewDTO;
import booker.BookingApp.dto.requestsAndReservations.ReservationRequestDTO;
import booker.BookingApp.enums.ReservationRequestStatus;
import booker.BookingApp.model.accommodation.Filter;
import booker.BookingApp.model.requestsAndReservations.ReservationRequest;
import booker.BookingApp.repository.ReservationRequestRepository;
import booker.BookingApp.service.interfaces.IReservationRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Service
public class ReservationRequestService implements IReservationRequestService {
    @Autowired
    ReservationRequestRepository repository;

    @Autowired
    AccommodationService accommodationService;

    @Autowired
    ReservationService reservationService;

    @Autowired
    AvailabilityService availabilityService;

    @Override
    public ReservationRequestDTO create(ReservationRequestDTO requestDto) {
        ReservationRequest request = new ReservationRequest(-1L, requestDto.getGuestId(), requestDto.getAccommodationId(),
                requestDto.getFromDate(), requestDto.getToDate(), requestDto.getNumberOfGuests(),
                requestDto.getStatus(), requestDto.isDeleted(), requestDto.getPrice());
        // if accommodation has automatically accepting reservation requests option, then
        // create reservation and change reservation request status
        if (!checkReservationAcceptingType(request.getAccommodationId()) &&
                !checkAvailability(request.getAccommodationId(), request.getFromDate(), request.getToDate())){
            request.setStatus(ReservationRequestStatus.ACCEPTED);
            requestDto.setStatus(ReservationRequestStatus.ACCEPTED);
            reservationService.create(requestDto);
        }
        this.repository.save(request);
        return ReservationRequestDTO.makeFromRequest(request);
    }

    public boolean checkAvailability(Long accommodationId, String fromDate, String toDate){
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
            Date from = sdf.parse(fromDate);
            Date to = sdf.parse(toDate);
            return availabilityService.checkForDateRange(accommodationId, from, to);
        } catch (ParseException e){
            System.out.println("Can not parse date");
        }
        return false;
    }

    @Override
    public boolean checkReservationAcceptingType(Long accommodationId) {
        try{
            AccommodationViewDTO accommodation = accommodationService.findOne(accommodationId);
            if (accommodation.isManual_accepting()){
                return true;
            }
        }
        catch (IOException e){
            System.out.println(e);
        }
        return false;
    }

    @Override
    public ReservationRequestDTO findOne(Long id) {
        return new ReservationRequestDTO(id, 1L, 1L, "12.12.2023.", "15.12.2023.", 2, ReservationRequestStatus.WAITING, false, 150.5);
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
