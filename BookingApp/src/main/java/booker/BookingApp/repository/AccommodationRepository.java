package booker.BookingApp.repository;

import booker.BookingApp.model.accommodation.Accommodation;
import booker.BookingApp.model.accommodation.AccommodationRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface AccommodationRepository  extends JpaRepository<Accommodation, Long> {
    @Query(value="select a from Accommodation a WHERE a.address.city like %:location% and :people >= a.min_capacity and :people <= a.max_capacity")
    public List<Accommodation> searchAccommodations(@Param("location") String location, @Param("people") int people);
}
