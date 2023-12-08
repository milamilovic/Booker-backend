package booker.BookingApp.model.accommodation;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

@Entity @ToString(exclude = {"amenities", "images", "availabilities", "prices", "ratings", "comments"})
public @Data @AllArgsConstructor @NoArgsConstructor class Accommodation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "short_description")
    private String shortDescription;
    @Column(name = "address", nullable = false)
    private String address;
    @OneToMany(mappedBy = "accommodation", fetch = FetchType.EAGER)
    @Column(name = "amenities", nullable = false)
    @JsonIgnore
    private List<Amenity> amenities;
    @OneToMany(mappedBy = "accommodation", fetch = FetchType.EAGER)
    @Column(name = "images", nullable = false)
    @JsonIgnore
    private List<Image> images;
    @OneToMany(mappedBy = "accommodation", fetch = FetchType.EAGER)
    @Column(name = "availabilities", nullable = false)
    @JsonIgnore
    private List<Availability> availabilities;

    @OneToMany(mappedBy = "accommodation", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Price> prices;
    @OneToMany(mappedBy = "accommodation", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<AccommodationRating> ratings;
    @OneToMany(mappedBy = "accommodation", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<AccommodationComment> comments;
    @Column(name = "deadline")
    private int deadline;
    @Column(name = "people", nullable = false)
    private int people;


}
