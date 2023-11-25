package booker.BookingApp.model.accommodation;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;
@Entity
public @Data @AllArgsConstructor @NoArgsConstructor
class Amenity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "accommodation_id")
    private Accommodation accommodation;

//    public Amenity(Long id, char[] name) {
//        this.id = id;
//        this.name = name;
//    }
    //private Image image;
}
