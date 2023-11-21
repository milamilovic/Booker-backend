package booker.BookingApp.controller;

import booker.BookingApp.dto.UserDTO;
import booker.BookingApp.model.User;
import booker.BookingApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/users")
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
}
