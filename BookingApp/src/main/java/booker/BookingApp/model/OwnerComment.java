package booker.BookingApp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
public @Data class OwnerComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "guest_id")
    private User guest;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "owner_id")
    private User owner;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "reported", nullable = false)
    private boolean reported;
}
