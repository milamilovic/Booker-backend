package booker.BookingApp.service.implementation;

import booker.BookingApp.model.users.User;
//import booker.BookingApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

//    @Autowired
//    private UserRepository userRepository;

    public User findOne(Long id){
        return new User();
        //return userRepository.findById(id).orElseGet(null);
    }

    public List<User> findAll() {
        return new ArrayList<User>();

        //return userRepository.findAll();
    }


    public void remove(Long id) {

        //userRepository.deleteById(id);
    }

    public User save(User user) {
        return user;
        //return userRepository.save(user);
    }

}
