package booker.BookingApp.repository;

import booker.BookingApp.model.accommodation.AccommodationRating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccommodationRatingRepository extends JpaRepository<AccommodationRating, Long> {


}
