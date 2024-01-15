package booker.BookingApp.springtesting.service;

import booker.BookingApp.repository.ReservationRequestRepository;
import booker.BookingApp.service.implementation.AvailabilityService;
import booker.BookingApp.service.implementation.ReservationRequestService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ReservationRequestCreatingTest {

    @Mock
    ReservationRequestRepository repository;

    @Mock
    AvailabilityService availabilityService;

    @InjectMocks
    ReservationRequestService service;

    @BeforeAll
    public void initialize() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void accommodationNotAvailable_returnsNull() {

    }

    @Test
    public void dateParseError_throwsRuntimeException() {

    }

    @Test
    public void dateValidation_startDateInPast_returnsNull() {

    }

    @Test
    public void dateValidation_endDateBeforeStartDate_returnsNull() {

    }

    @Test
    public void priceValidation_priceNotGood_returnsNull() {

    }

    @Test
    public void nonExistingAccommodation_throwsRuntimeException() {

    }

    @ParameterizedTest
    @ValueSource(ints={-3, 0, 1, 4, 9})
    public void numOfGuestsNotGood_returnsNull(int numOfPeople) {
        //accommodation capacity 2-3

    }

    @Test
    public void positiveTest_returnsReservationRequestDto() {

    }

}
