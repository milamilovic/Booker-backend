package booker.BookingApp.dto.requestsAndReservations;

import booker.BookingApp.enums.ReservationRequestStatus;
import booker.BookingApp.model.requestsAndReservations.Reservation;
import booker.BookingApp.model.requestsAndReservations.ReservationRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

public @Data @AllArgsConstructor class ReservationRequestDTO {
    private Long guestId;
    private Long accommodationId;
    private Long id;
    private Date fromDate;
    private Date toDate;
    private int numberOfGuests;
    private ReservationRequestStatus status;
    private boolean deleted;

    public ReservationRequestDTO makeFromRequest(ReservationRequest request){
        ReservationRequestDTO requestDTO = new ReservationRequestDTO(
                request.getGuestId(),
                request.getAccommodationId(),
                request.getId(),
                request.getFromDate(),
                request.getToDate(),
                request.getNumberOfGuests(),
                request.getStatus(),
                request.isDeleted()
        );
        return  requestDTO;
    }
}
