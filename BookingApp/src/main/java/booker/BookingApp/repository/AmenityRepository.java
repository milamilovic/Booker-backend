package booker.BookingApp.repository;

import booker.BookingApp.model.accommodation.Accommodation;
import booker.BookingApp.model.accommodation.Amenity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AmenityRepository extends JpaRepository<Amenity, Long> {
    @Query(value="select distinct a.name from Amenity a")
    public List<String> getDistinctNames();

    public List<Amenity> getAmenitiesByAccommodation_Id(Long accommodation_id);

    @Query(value="select distinct a.name, a.image_path from Amenity a")
    public List<Amenity> findAllDistinct();
}
