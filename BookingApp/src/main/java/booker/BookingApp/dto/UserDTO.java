package booker.BookingApp.dto;

import booker.BookingApp.model.User;
import lombok.Data;

public @Data class UserDTO {
    private Long id;

    private String name;

    private String surname;

    private String email;
    private String password;

    private String address;

    private String phone;


    public UserDTO() {
    }

    public UserDTO(User user) {
        this(user.getId(), user.getName(), user.getSurname(), user.getEmail(), user.getPassword(), user.getAddress(), user.getPhone());
    }

    public UserDTO(Long id, String name, String surname, String email, String address, String phone, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.password = password;
    }
}
