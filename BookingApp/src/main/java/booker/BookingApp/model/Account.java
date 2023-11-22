package booker.BookingApp.model;

import booker.BookingApp.enums.Role;
import lombok.Data;

public @Data class Account {
    private Long id;
    private Long userId;

    private String password;
    private Role role;
    private boolean blocked;
    private boolean deleted;
}
