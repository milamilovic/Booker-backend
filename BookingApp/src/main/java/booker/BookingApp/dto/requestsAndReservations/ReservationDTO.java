package booker.BookingApp.dto.requestsAndReservations;

import booker.BookingApp.enums.ReservationRequestStatus;
import booker.BookingApp.model.requestsAndReservations.Reservation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

public @Data @AllArgsConstructor @NoArgsConstructor class ReservationDTO {
    private Long guestId;
    private Long accommodationId;
    private Long id;
    private Date fromDate;
    private Date toDate;
    private int numberOfGuests;
    private ReservationRequestStatus status;
    private boolean deleted;
    private double price;

    public ReservationDTO makeFromReservation(Reservation reservation){
        ReservationDTO reservationDTO = new ReservationDTO();
        reservationDTO.guestId = reservation.getGuestId();
        reservationDTO.accommodationId = reservation.getAccommodationId();
        reservationDTO.id = reservation.getId();
        reservationDTO.fromDate = reservation.getFromDate();
        reservationDTO.toDate = reservation.getToDate();
        reservationDTO.numberOfGuests = reservation.getNumberOfGuests();
        reservationDTO.status = reservation.getStatus();
        reservationDTO.deleted = reservation.isDeleted();
        reservationDTO.price = reservation.getPrice();
        return  reservationDTO;
    }
}
