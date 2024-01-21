package booker.BookingApp.repository;

import booker.BookingApp.model.users.ProfilePicture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProfilePictureRepository extends JpaRepository<ProfilePicture, Long> {
    @Query(value = "SELECT p FROM ProfilePicture p WHERE p.user.id=:id")
    ProfilePicture getProfilePictureForUser(@Param("id") Long id);
}
