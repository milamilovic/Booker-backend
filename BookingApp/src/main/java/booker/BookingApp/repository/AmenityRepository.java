package booker.BookingApp.repository;

import booker.BookingApp.model.accommodation.Amenity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AmenityRepository extends JpaRepository<Amenity, Long> {

    @Query("SELECT DISTINCT a.name from Amenity a")
    List<String> findDistinctAmenityNames();

    @Query("SELECT DISTINCT a FROM Amenity a WHERE a.name = ?1")
    Amenity findByName(String name);
}
