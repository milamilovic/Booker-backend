package booker.BookingApp.model.accommodation;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
public @Data @AllArgsConstructor @NoArgsConstructor class Availability {
    @Id
    private Long id;
    private Date startDate;
    private Date endDate;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "accommodation_id")
    private Accommodation accommodation;
}
