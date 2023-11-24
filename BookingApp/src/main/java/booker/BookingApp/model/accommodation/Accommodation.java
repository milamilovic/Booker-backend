package booker.BookingApp.model.accommodation;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
public @Data @AllArgsConstructor class Accommodation {
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
    //private List<Amenity> amenities;
    //private ArrayList<Image> images;
    //private ArrayList<Availability> availabilities;
    //private ArrayList<Price> prices;

    //private ArrayList<AccommodationRating> ratings;
    @OneToMany(mappedBy = "accommodation", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private ArrayList<AccommodationComment> comments;
    @Column(name = "deadline", nullable = false)
    private int deadline;

    public Accommodation(){

    }
}
