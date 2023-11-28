package booker.BookingApp.dto.requestsAndReservations;

import booker.BookingApp.enums.ReservationRequestStatus;
import booker.BookingApp.model.requestsAndReservations.Reservation;
import booker.BookingApp.model.requestsAndReservations.ReservationRequest;
import lombok.Data;

import java.util.Date;

public @Data class ReservationRequestDTO {
    private Date fromDate;
    private Date toDate;
    private int numberOfGuests;
    private ReservationRequestStatus status;
    private boolean deleted;

    public ReservationRequestDTO makeFromRequest(ReservationRequest request){
        ReservationRequestDTO requestDTO = new ReservationRequestDTO();
        requestDTO.fromDate = request.getFromDate();
        requestDTO.toDate = request.getToDate();
        requestDTO.numberOfGuests = request.getNumberOfGuests();
        requestDTO.deleted = request.isDeleted();
        requestDTO.status = request.getStatus();
        return  requestDTO;
    }
}
