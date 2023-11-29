package booker.BookingApp.service.interfaces;

import booker.BookingApp.model.users.User;

import java.util.List;

public interface IUserService {
    public User findOne(Long id);
    public List<User> findAll();
    public User save(User user);
    public User findByEmail(String email);
    public User findByEmailAndPassword(String email, String password);
}
