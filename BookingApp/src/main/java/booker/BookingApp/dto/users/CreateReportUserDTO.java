package booker.BookingApp.dto.users;

import booker.BookingApp.model.users.UserReport;
import lombok.Data;

public @Data class CreateReportUserDTO {
    private Long reportedId;
    private Long reporterId;
    private String reason;

    public CreateReportUserDTO() {
    }

    public CreateReportUserDTO(UserReport userReport) {
        this(userReport.getReported().getId(), userReport.getReporter().getId(), userReport.getReason());
    }

    public CreateReportUserDTO(Long reportedId, Long reporterId, String reason) {
        this.reportedId = reportedId;
        this.reporterId = reporterId;
        this.reason = reason;
    }


}
