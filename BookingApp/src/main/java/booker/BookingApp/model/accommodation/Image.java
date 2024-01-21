package booker.BookingApp.model.accommodation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @JsonIgnoreProperties(value= {"accommodation"})
public @Data @AllArgsConstructor
@NoArgsConstructor class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @JoinColumn(name = "path_front")
    String path_front;

    @JoinColumn(name = "path_mobile")
    String path_mobile;

    @ManyToOne
    @JoinColumn(name = "accommodation_id")
    private Accommodation accommodation;

}
