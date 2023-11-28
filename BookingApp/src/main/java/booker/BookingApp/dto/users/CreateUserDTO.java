package booker.BookingApp.dto.users;

import booker.BookingApp.enums.Role;
import booker.BookingApp.model.users.User;
import lombok.Data;

public @Data class CreateUserDTO {
    public String name;
    public String surname;
    public String email;
    public String password;
    public String address;
    public String phone;
    public Role role;

    public CreateUserDTO() {
    }

    public CreateUserDTO(User user) {
        this(user.getName(), user.getSurname(), user.getEmail(), user.getPassword(), user.getAddress(), user.getPhone(), user.getRole());
    }

    public CreateUserDTO(String name, String surname, String email, String password, String address, String phone, Role role) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.address = address;
        this.phone = phone;
        this.role = role;
    }

}
