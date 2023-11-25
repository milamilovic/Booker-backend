package booker.BookingApp.repository;

import booker.BookingApp.model.commentsAndRatings.OwnerRating;
import booker.BookingApp.model.accommodation.AccommodationComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccommodationCommentRepository extends JpaRepository<AccommodationComment, Long> {
    @Query("select ac from AccommodationComment ac where ac.accommodation.id = ?1")
    public List<AccommodationComment> findAllForAccommodation(Long accommodationId);
}
