package booker.BookingApp.dto.users;

import booker.BookingApp.model.users.ProfilePicture;
import booker.BookingApp.model.users.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public @Data @AllArgsConstructor @NoArgsConstructor class UpdateUserDTO {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String address;
    private String phone;
    private ProfilePicture profilePicture;

    public UpdateUserDTO(User user) {
    }
}
