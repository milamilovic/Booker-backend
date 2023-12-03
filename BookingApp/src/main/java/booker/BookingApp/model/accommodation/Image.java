package booker.BookingApp.model.accommodation;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
public @Data @AllArgsConstructor class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @JoinColumn(name = "path")
    String path;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "accommodation_id")
    private Accommodation accommodation;
}
