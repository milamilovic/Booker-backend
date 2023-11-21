package booker.BookingApp.repository;

import booker.BookingApp.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    public User findUserById(Integer id);

    Optional<User> findUserByEmail(String email);
    User findOneUserByEmail(String email);

    public Page<User> findAll(Pageable pageable);

    public List<User> findByNameAndSurnameAllIgnoringCase(String name, String surname);

}
