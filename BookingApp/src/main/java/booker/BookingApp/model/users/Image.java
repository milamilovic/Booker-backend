package booker.BookingApp.model.users;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
public @Data @AllArgsConstructor class Image {
    Long id;
    String path;
    private User user;
}
