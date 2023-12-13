package booker.BookingApp.model.commentsAndRatings;

import booker.BookingApp.model.users.Owner;
import booker.BookingApp.model.users.User;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
public @Data class OwnerRating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "guest_id")
    private User guest;

    @Column(name = "rate", nullable = false)
    private float rate;

    @Column(name = "date", nullable = false)
    private Date date;
    @Column(name = "reported", nullable = false)
    private boolean reported;
}
