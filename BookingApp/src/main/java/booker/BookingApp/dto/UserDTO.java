package booker.BookingApp.dto;

import booker.BookingApp.model.User;

public class UserDTO {
    private Integer id;

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

    public UserDTO(Integer id, String name, String surname, String email, String address, String phone) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.address = address;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }
}
