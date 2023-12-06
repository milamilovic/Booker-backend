package booker.BookingApp.model.users;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
public @Data @AllArgsConstructor class ProfilePicture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "path", nullable = false)
    String path;
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;


    public ProfilePicture() {
    }
}
