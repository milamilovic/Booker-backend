package booker.BookingApp.repository;

import booker.BookingApp.model.accommodation.AccommodationComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccommodationCommentRepository extends JpaRepository<AccommodationComment, Long> {
    public AccommodationComment findOne(Long id);
    public AccommodationComment findByAccommodationId(Long accommodationId);
    public List<AccommodationComment> findAll();
    public List<AccommodationComment> findAllForAccommodation(Long accommodationId);
    public List<AccommodationComment> findAllReported();
    public AccommodationComment create(AccommodationComment accommodationComment);
    public AccommodationComment update(AccommodationComment accommodationComment);
    public void delete(Long id);
}
