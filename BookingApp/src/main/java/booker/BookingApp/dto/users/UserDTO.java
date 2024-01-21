package booker.BookingApp.dto.users;

import booker.BookingApp.enums.Role;
import booker.BookingApp.model.users.ProfilePicture;
import booker.BookingApp.model.users.User;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

public @Data class UserDTO {
    private Long id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String surname;

    @NotEmpty
    private String email;
    @NotEmpty
    private String password;

    @NotEmpty
    private String address;

    @NotEmpty
    private String phone;
    @NotNull
    private Role role;
    private ProfilePicture profilePicture;

    public UserDTO() {
    }

    public UserDTO(User user) {
        this(user.getId(), user.getName(), user.getSurname(), user.getEmail(), user.getPassword(), user.getAddress(), user.getPhone(), user.getRole(), user.getProfilePicture());

    }

    public UserDTO(Long id, String name, String surname, String email, String password, String address, String phone, Role role, ProfilePicture profilePicture) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.address = address;
        this.phone = phone;
        this.role = role;
        this.profilePicture = profilePicture;
    }

    public static UserDTO makeFromUser(User user){
        return new UserDTO(user.getId(), user.getName(), user.getSurname(), user.getEmail(),
                user.getPassword(), user.getAddress(), user.getPhone(), user.getRole(), user.getProfilePicture());
    }
}
