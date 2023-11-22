package booker.BookingApp.repository;

import booker.BookingApp.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface UserRepository {

    Collection<User> findAll();

    User create(User user) throws Exception;

    User findOne(Long id);

    User update(User user) throws Exception;

    void delete(Long id);
}
