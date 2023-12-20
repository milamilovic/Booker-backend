package booker.BookingApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import booker.BookingApp.model.accommodation.Accommodation;
import booker.BookingApp.model.accommodation.Amenity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AmenityRepository extends JpaRepository<Amenity, Long> {

    @Query("SELECT DISTINCT a.name from Amenity a")
    List<String> findDistinctAmenityNames();

    @Query("SELECT DISTINCT a FROM Amenity a WHERE a.name = ?1")
    Amenity findByName(String name);
    @Query(value="select distinct a.name from Amenity a")
    public List<String> getDistinctNames();

    public List<Amenity> getAmenitiesByAccommodation_Id(Long accommodation_id);

    @Query(value="select distinct a from Amenity a")
    public List<Amenity> findAllDistinct();

    @Query(value="select distinct a.name from Amenity a where :id=a.id")
    public List<String> getNamesForAcc(@Param("id") Long id);

    @Query(value = "delete from Amenity a where :name=a.name and :id=a.accommodation")
    public void removeAmenityFromAcc(@Param("name") String amenity, @Param("id") Long accId);
}
