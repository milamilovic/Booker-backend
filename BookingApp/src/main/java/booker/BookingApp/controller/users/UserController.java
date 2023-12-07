package booker.BookingApp.controller.users;

import booker.BookingApp.dto.users.CreateUserDTO;
import booker.BookingApp.dto.users.LoginUserDTO;
import booker.BookingApp.dto.users.UpdateUserDTO;
import booker.BookingApp.dto.users.UserDTO;
import booker.BookingApp.model.users.User;
import booker.BookingApp.service.implementation.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/all")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<User> users = userService.findAll();

        List<UserDTO> usersDTO = new ArrayList<>();
        for (User u : users) {
            usersDTO.add(new UserDTO(u));
        }

        return new ResponseEntity<>(usersDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Long id) {
        User user = userService.findOne(id);

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new UserDTO(user), HttpStatus.OK);
    }



    @PostMapping(consumes = "application/json")
    public ResponseEntity<CreateUserDTO> saveUser(@RequestBody CreateUserDTO createUserDTO) {
        User user = new User();

        user.setName(createUserDTO.getName());
        user.setSurname(createUserDTO.getSurname());
        user.setEmail(createUserDTO.getEmail());
        user.setPassword(createUserDTO.getPassword());
        user.setAddress(createUserDTO.getAddress());
        user.setPhone(createUserDTO.getPhone());
        user.setRole(createUserDTO.getRole());
        user = userService.save(user);
        return new ResponseEntity<>(new CreateUserDTO(user), HttpStatus.CREATED);
    }

    @PutMapping(consumes = "application/json")
    public ResponseEntity<UpdateUserDTO> updateUser(@RequestBody UpdateUserDTO updateUserDTO) {
        User user = userService.findOne(updateUserDTO.getId());

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        user.setName(updateUserDTO.getName());
        user.setSurname(updateUserDTO.getSurname());
        user.setEmail(updateUserDTO.getEmail());
        user.setPassword(updateUserDTO.getPassword());
        user.setAddress(updateUserDTO.getAddress());
        user.setPhone(updateUserDTO.getPhone());
        user.setProfilePicture(updateUserDTO.getProfilePicture());

        user = userService.save(user);
        return new ResponseEntity<>(new UpdateUserDTO(user), HttpStatus.OK);
    }

    @GetMapping(value = "/by-email={email}")
    public ResponseEntity<UserDTO> findByEmail(@PathVariable String email) {
        User user = userService.findByEmail(email);

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(new UserDTO(user), HttpStatus.OK);
    }

    @GetMapping(consumes = "application/json")
    public ResponseEntity<UserDTO> findByEmailAndPassword(@RequestBody LoginUserDTO loginUserDTO) {
        User user = userService.findByEmailAndPassword(loginUserDTO.getEmail(), loginUserDTO.getPassword());

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new UserDTO(user), HttpStatus.OK);
    }

}
