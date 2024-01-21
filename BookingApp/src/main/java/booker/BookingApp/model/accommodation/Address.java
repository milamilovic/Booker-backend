package booker.BookingApp.model.accommodation;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public @Data class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "street")
    private String street;

    @JoinColumn(name = "city")
    private String city;

    @JoinColumn(name = "latitude")
    private double latitude;

    @JoinColumn(name = "longitude")
    private double longitude;

    @OneToOne
    @JoinColumn(name = "accommodation_id")
    private Accommodation accommodation;


}
