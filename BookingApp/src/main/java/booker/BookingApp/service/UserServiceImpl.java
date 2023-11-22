package booker.BookingApp.service;

import booker.BookingApp.model.User;
import booker.BookingApp.repository.InMemoryUserRepository;
import booker.BookingApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private InMemoryUserRepository userRepository;


    @Override
    public Collection<User> findAll() {
        Collection<User> users = userRepository.findAll();
        return users;
    }

    @Override
    public User findOne(long id) {
        User user = userRepository.findOne(id);
        return user;
    }

    @Override
    public User create(User user) throws Exception {
        if (user.getId() != null) {
            throw new Exception("Id must be null during persistence of new entity");
        }
        User savedGreeting = userRepository.create(user);
        return savedGreeting;
    }

    @Override
    public User update(User user) throws Exception {
        User userToUpdate = userRepository.findOne(user.getId());
        if (userToUpdate == null) {
            throw new Exception("Entity not found");
        }
        userToUpdate.setName(user.getName());
        userToUpdate.setSurname(user.getSurname());
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setAddress(user.getAddress());
        userToUpdate.setPhone(user.getPhone());

        User updatedUser = userRepository.create(userToUpdate);
        return updatedUser;
    }

    @Override
    public void delete(long id) {
        userRepository.delete(id);
    }
}
