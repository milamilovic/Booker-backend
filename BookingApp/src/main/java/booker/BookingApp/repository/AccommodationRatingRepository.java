package booker.BookingApp.repository;

import booker.BookingApp.model.accommodation.AccommodationRating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccommodationRatingRepository extends JpaRepository<AccommodationRating, Long> {

    public List<AccommodationRating> findAll();
    public List<AccommodationRating> findAllForAccommodation(Long accommodationId);
    public List<AccommodationRating> findAllReported();
    public AccommodationRating findOne(Long id);
    public AccommodationRating create(AccommodationRating accommodationRating);
    public AccommodationRating update(AccommodationRating accommodationRating);
    public void delete(Long id);
}
