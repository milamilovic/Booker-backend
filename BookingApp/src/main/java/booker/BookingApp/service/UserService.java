package booker.BookingApp.service;

import booker.BookingApp.model.User;
import booker.BookingApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User findUserById(Integer id) {
        if (userRepository.findUserById(id) == null) {
            return null;
        }
        return userRepository.findUserById(id);
    }

    public User findUserByEmail(String email) {
        return this.userRepository.findUserByEmail(email).orElse(null);
    }

    public User findOneUserByEmail(String email) {
        return this.userRepository.findOneUserByEmail(email);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Page<User> findAll(Pageable pageable) {
        return this.userRepository.findAll(pageable);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void remove(Integer id) {
        userRepository.deleteById(id);
    }
}
