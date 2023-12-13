package booker.BookingApp.model.users;

import booker.BookingApp.model.commentsAndRatings.OwnerComment;
import booker.BookingApp.model.commentsAndRatings.OwnerRating;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.ArrayList;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@ToString(exclude = {"ratings", "comments"})
@DiscriminatorValue("OWNER")
public class Owner extends User {
    @Column(name = "reported")
    private boolean reported;
    @Column(name = "blocked")
    private boolean blocked;
    @Column(name = "deleted")
    private boolean deleted;
    @OneToMany(mappedBy = "owner", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnore
    private ArrayList<OwnerRating> ratings;
    @OneToMany(mappedBy = "owner", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnore
    private ArrayList<OwnerComment> comments;
}
