package booker.BookingApp.dto.requestsAndReservations;

import booker.BookingApp.enums.ReservationRequestStatus;
import booker.BookingApp.enums.ReservationStatus;
import booker.BookingApp.model.requestsAndReservations.Reservation;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

public @Data @AllArgsConstructor @NoArgsConstructor class ReservationDTO {
    @NotNull
    private Long guestId;
    @NotNull
    private Long accommodationId;
    private Long id;
    @NotEmpty
    private String fromDate;
    @NotEmpty
    private String toDate;
    @Min(1)
    private int numberOfGuests;
    @NotNull
    private ReservationRequestStatus requestStatus;
    @NotNull
    private ReservationStatus status;
    private boolean deleted;
    @Min(0)
    private double price;
    @NotEmpty
    private String toTime;

    public static ReservationDTO makeFromReservation(Reservation reservation){
        ReservationDTO reservationDTO = new ReservationDTO();
        reservationDTO.guestId = reservation.getGuestId();
        reservationDTO.accommodationId = reservation.getAccommodation().getId();
        reservationDTO.id = reservation.getId();
        reservationDTO.fromDate = reservation.getFromDate();
        reservationDTO.toDate = reservation.getToDate();
        reservationDTO.numberOfGuests = reservation.getNumberOfGuests();
        reservationDTO.requestStatus = reservation.getRequestStatus();
        reservationDTO.status = reservation.getStatus();
        reservationDTO.deleted = reservation.isDeleted();
        reservationDTO.price = reservation.getPrice();
        reservationDTO.toTime = reservationDTO.getToTime();
        return  reservationDTO;
    }
}
