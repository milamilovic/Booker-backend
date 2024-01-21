package booker.BookingApp.model.users;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity @JsonIgnoreProperties(value= {"user"})
public @Data @AllArgsConstructor class ProfilePicture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "path_front", nullable = false)
    String path;
    @Column(name = "path_mobile", nullable = false)
    String path_mobile;
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;


    public ProfilePicture() {
    }
}
