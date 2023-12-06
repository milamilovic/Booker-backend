package booker.BookingApp.model.accommodation;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

@Entity
public @Data @AllArgsConstructor @NoArgsConstructor class Accommodation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "short_description", nullable = false)
    private String shortDescription;
    @Column(name = "address", nullable = false)
    private String address;
    @OneToMany(mappedBy = "accommodation", fetch = FetchType.EAGER)
    @Column(name = "amenitites", nullable = false)
    private List<Amenity> amenities;
    @OneToMany(mappedBy = "accommodation", fetch = FetchType.EAGER)
    @Column(name = "images", nullable = false)
    private List<Image> images;
    @OneToMany(mappedBy = "accommodation", fetch = FetchType.EAGER)
    @Column(name = "availabilities", nullable = false)
    private List<Availability> availabilities;

    @OneToMany(mappedBy = "accommodation", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Price> prices;
    @OneToMany(mappedBy = "accommodation", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<AccommodationRating> ratings;
    @OneToMany(mappedBy = "accommodation", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<AccommodationComment> comments;
    @Column(name = "deadline", nullable = false)
    private int deadline;
    @Column(name = "people", nullable = false)
    private int people;


}
