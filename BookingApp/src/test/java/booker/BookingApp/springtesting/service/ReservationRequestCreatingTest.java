package booker.BookingApp.springtesting.service;

import booker.BookingApp.dto.accommodation.AccommodationViewDTO;
import booker.BookingApp.dto.accommodation.AvailabilityDTO;
import booker.BookingApp.dto.requestsAndReservations.ReservationRequestDTO;
import booker.BookingApp.enums.ReservationRequestStatus;
import booker.BookingApp.model.accommodation.*;
import booker.BookingApp.repository.ReservationRequestRepository;
import booker.BookingApp.service.implementation.AccommodationService;
import booker.BookingApp.service.implementation.AvailabilityService;
import booker.BookingApp.service.implementation.ReservationRequestService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.testng.annotations.BeforeMethod;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertThrows;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-test.properties")
public class ReservationRequestCreatingTest {
    @Mock
    ReservationRequestRepository repository;

    @Mock
    AvailabilityService availabilityService;

    @Mock
    AccommodationService accommodationService;

    ReservationRequestDTO requestDTO;
    ReservationRequestDTO invalidRequestDTO;
    Date startDate;
    Date endDate;

    @InjectMocks
    ReservationRequestService service;

    @BeforeEach
    public void initialize() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        this.startDate = sdf.parse("2023-01-05");
        this.endDate = sdf.parse("2023-01-15");
        this.requestDTO = new ReservationRequestDTO(1L, 1L,
                1L, "2023-01-05", "2023-01-15", 2,
                ReservationRequestStatus.WAITING, false, 250);
        this.invalidRequestDTO = new ReservationRequestDTO(1L, 1L,
                1L, "2023-01-05", "2023-01-15", 2,
                ReservationRequestStatus.WAITING, false, 250);
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void accommodationNotAvailable_returnsNull() throws IOException {
        when(availabilityService.checkIfAvailable(1L, this.startDate, this.endDate)).thenReturn(false);
        AccommodationViewDTO accommodation = new AccommodationViewDTO(1L, "title", "description",
                null, new ArrayList<Amenity>(), new ArrayList<Image>(), new ArrayList<AvailabilityDTO>(),
                new ArrayList<Price>(), new ArrayList<AccommodationRating>(), new ArrayList<AccommodationComment>(),
                2L, 2, 3, true);
        when(accommodationService.findOne(1L)).thenReturn(accommodation);
        assertNull(service.create(this.requestDTO));
        verify(availabilityService).checkIfAvailable(1L, this.startDate, this.endDate);
        verifyNoMoreInteractions(availabilityService);
        verifyNoInteractions(repository);
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
