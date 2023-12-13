package booker.BookingApp.repository;

import booker.BookingApp.model.accommodation.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
