package booker.BookingApp.dto.users;

import booker.BookingApp.model.users.User;
import lombok.Data;

public @Data class UserDTO {
    private Long id;

    private String name;

    private String surname;

    private String email;

    private String address;

    private String phone;

    public UserDTO() {
    }

    public UserDTO(User user) {
        this(user.getId(), user.getName(), user.getSurname(), user.getEmail(), user.getAddress(), user.getPhone());
    }

    public UserDTO(Long id, String name, String surname, String email, String address, String phone) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.address = address;
        this.phone = phone;
    }
}
