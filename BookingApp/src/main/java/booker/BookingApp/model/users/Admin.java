package booker.BookingApp.model.users;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@DiscriminatorValue("ADMIN")
public class Admin extends User {

    public void setProfilePicturePath(String path){
        this.getProfilePicture().setPath(path);
    }
}
