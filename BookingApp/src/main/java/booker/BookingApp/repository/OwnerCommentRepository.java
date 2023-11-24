package booker.BookingApp.repository;

import booker.BookingApp.model.OwnerComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OwnerCommentRepository extends JpaRepository<OwnerComment, Long> {

}