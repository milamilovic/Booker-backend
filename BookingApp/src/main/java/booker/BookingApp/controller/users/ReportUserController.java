package booker.BookingApp.controller.users;

import booker.BookingApp.dto.users.CreateReportUserDTO;
import booker.BookingApp.dto.users.UserReportDTO;
import booker.BookingApp.service.implementation.UserReportService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/report_user")
@CrossOrigin(origins = "http://localhost:4200")
public class ReportUserController {
    @Autowired
    private UserReportService userReportService;

    @GetMapping(value = "/all")
    public ResponseEntity<List<UserReportDTO>> getAllUserReports() {
        List<UserReportDTO> userReportDTOS = userReportService.findAll();
        return new ResponseEntity<>(userReportDTOS, HttpStatus.OK);
    }

    @PostMapping(value = "/add_report", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserReportDTO> create(@Valid @RequestBody CreateReportUserDTO createReportUserDTO) {
        UserReportDTO userReportDTO = userReportService.create(createReportUserDTO);
        return new ResponseEntity<>(userReportDTO, HttpStatus.CREATED);
    }
}
