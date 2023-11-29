package booker.BookingApp.repository;

import booker.BookingApp.enums.PriceType;
import booker.BookingApp.model.accommodation.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PriceRepository extends JpaRepository<Price, Long> {
    @Query("select p from Price p where p.accommodation.id = ?1")
    public List<Price> findAllForAccommodation(Long accommodationId);
    @Query("select p from Price p where p.type = 0")
    public List<Price> findAllForTypeAccommodation();

    @Query("select p from Price p where p.type = 1")
    public List<Price> findAllForTypeGuest();
}
