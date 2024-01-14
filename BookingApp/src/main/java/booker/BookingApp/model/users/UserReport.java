package booker.BookingApp.model.users;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
public @Data class UserReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "reported_id")
    private User reported;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "reporter_id")
    private User reporter;

    @Column(name = "reason")
    private String reason;

    @Column(name = "date", nullable = false)
    private Date date;
}
