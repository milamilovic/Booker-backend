package booker.BookingApp.dto;

import booker.BookingApp.model.Reservation;

import java.util.Date;

public class ReservationDTO {
    private Date fromDate;
    private Date toDate;
    private int numberOfGuests;

    public ReservationDTO makeFromReservation(Reservation reservation){
        ReservationDTO reservationDTO = new ReservationDTO();
        reservationDTO.fromDate = reservation.getFromDate();
        reservationDTO.toDate = reservation.getToDate();
        reservationDTO.numberOfGuests = reservation.getNumberOfGuests();
        return  reservationDTO;
    }
}
