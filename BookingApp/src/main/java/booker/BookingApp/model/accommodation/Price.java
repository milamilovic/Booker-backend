package booker.BookingApp.model.accommodation;

import booker.BookingApp.enums.PriceType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Entity
public @Data class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "accommodation_id")
    private Accommodation accommodation;

    @Column(name = "cost", nullable = false)
    private double cost;

    @Column(name = "fromDate", nullable = false)
    private Date fromDate;

    @Column(name = "toDate", nullable = false)
    private Date toDate;

    @Column(name = "type", nullable = false)
    private PriceType type;
}
