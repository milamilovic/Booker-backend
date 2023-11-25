package booker.BookingApp.model.users;

import booker.BookingApp.enums.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
public @Data class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //private User user;

    private String password;
    private Role role;
    private boolean blocked;
    private boolean deleted;
}
