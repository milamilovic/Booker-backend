package booker.BookingApp.dto.users;

import booker.BookingApp.model.users.User;
import booker.BookingApp.validation.PasswordCustomConstraint;
import jakarta.validation.constraints.Email;
import lombok.Data;

public @Data class LoginUserDTO {
    @Email(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")
    private String email;
    @PasswordCustomConstraint(message = "Password must contain exactly 8 digits")
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
