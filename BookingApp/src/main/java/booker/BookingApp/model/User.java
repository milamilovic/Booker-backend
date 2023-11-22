package booker.BookingApp.model;


import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;


public @Data class User {
    private Long id;
    private String name;

    private String surname;


    private String email;

    private String address;

    private String phone;


}
