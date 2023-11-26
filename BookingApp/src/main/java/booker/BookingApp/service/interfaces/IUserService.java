package booker.BookingApp.service.interfaces;

import booker.BookingApp.model.User;

import java.util.List;

public interface IUserService {
    public User findOne(Long id);
    public List<User> findAll();
    public void remove(Long id);
    public User save(User user);
}
