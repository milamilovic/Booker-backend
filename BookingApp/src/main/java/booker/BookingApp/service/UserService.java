package booker.BookingApp.service;

import booker.BookingApp.model.User;

import java.util.Collection;

public interface UserService {

    Collection<User> findAll();

    User findOne(long id);

    User create(User user) throws Exception;

    User update(User user) throws Exception;

    void delete(long id);

}
