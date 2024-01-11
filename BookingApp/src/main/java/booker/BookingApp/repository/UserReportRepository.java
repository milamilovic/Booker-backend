package booker.BookingApp.repository;

import booker.BookingApp.model.users.UserReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserReportRepository extends JpaRepository<UserReport, Long> {
}
