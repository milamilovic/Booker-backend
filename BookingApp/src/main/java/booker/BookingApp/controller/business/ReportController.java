package booker.BookingApp.controller.business;

import booker.BookingApp.dto.business.AccommodationReportDTO;
import booker.BookingApp.dto.business.IntervalReportDTO;
import booker.BookingApp.model.accommodation.Filter;
import booker.BookingApp.service.interfaces.IReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@RestController
@RequestMapping("/api/report")
@CrossOrigin(origins = "http://localhost:4200")
public class ReportController {
    @Autowired
    IReportService service;

    //get report for owner for date interval
    @GetMapping(value = "/owner/{ownerId}/interval/{from}/{to}", produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('OWNER')")
    public ResponseEntity<IntervalReportDTO> getIntervalReport(@PathVariable Long ownerId ,
                                                               @PathVariable String from,
                                                               @PathVariable String to){
        IntervalReportDTO report = service.getIntervalReport(ownerId, from, to);
        return new ResponseEntity<>(report, HttpStatus.OK);
    }

    //get report for owners accommodation
    @GetMapping(value = "/owner/{ownerId}/accommodation/{accommodationId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('OWNER')")
    public ResponseEntity<AccommodationReportDTO> getAccommodationReport(@PathVariable Long ownerId ,
                                                                         @PathVariable Long accommodationId) throws IOException {
        AccommodationReportDTO report = service.getAccommodationReport(ownerId, accommodationId);
        return new ResponseEntity<>(report, HttpStatus.OK);
    }

}
