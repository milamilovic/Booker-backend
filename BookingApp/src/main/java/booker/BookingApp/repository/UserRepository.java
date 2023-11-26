package booker.BookingApp.repository;

import booker.BookingApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<User, Long> {


}
