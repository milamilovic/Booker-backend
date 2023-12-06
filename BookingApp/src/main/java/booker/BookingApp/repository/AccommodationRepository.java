package booker.BookingApp.repository;

import booker.BookingApp.model.accommodation.Accommodation;
import booker.BookingApp.model.accommodation.AccommodationRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface AccommodationRepository  extends JpaRepository<Accommodation, Long> {
    //TODO: add searching dates
    @Query(value="select a from Accommodation a LEFT JOIN FETCH a.images WHERE a.address like %:location% and a.people <= :people")
    public List<Accommodation> searchAccommodations(@Param("location") String location, @Param("people") int people);
}
