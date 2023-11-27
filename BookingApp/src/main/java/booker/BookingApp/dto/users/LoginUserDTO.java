package booker.BookingApp.dto.users;

import booker.BookingApp.model.users.User;
import lombok.Data;

public @Data class LoginUserDTO {
    private String email;
    private String password;

    public LoginUserDTO() {
    }

    public LoginUserDTO(User user) {
        this(user.getEmail(), user.getPassword());
    }

    public LoginUserDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
