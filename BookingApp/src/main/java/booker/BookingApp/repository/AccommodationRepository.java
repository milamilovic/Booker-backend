package booker.BookingApp.repository;

import booker.BookingApp.model.accommodation.Accommodation;
import booker.BookingApp.model.accommodation.AccommodationRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccommodationRepository  extends JpaRepository<Accommodation, Long> {
}
