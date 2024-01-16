package booker.BookingApp.springtesting.repository;

import booker.BookingApp.enums.Role;
import booker.BookingApp.model.accommodation.Accommodation;
import booker.BookingApp.model.users.User;
import booker.BookingApp.repository.ReservationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

@DataJpaTest
@ActiveProfiles("test")
public class ReservationRepositoryTest {
    @Autowired
    private ReservationRepository reservationRepository;


    @Test
    public void shouldFindCurrentReservations() {
    }
}
