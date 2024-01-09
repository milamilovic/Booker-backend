package booker.BookingApp.controller.business;
import booker.BookingApp.model.accommodation.Filter;
import booker.BookingApp.model.business.Report;
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
    @GetMapping(value = "/owner/{ownerId}/interval", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ArrayList<Report>> getIntervalReport(@PathVariable Long ownerId ,
                                                               @RequestParam String from,
                                                               @RequestParam String to){
        ArrayList<Report> reports = service.getIntervalReport(ownerId, from, to);
        return new ResponseEntity<>(reports, HttpStatus.OK);
    }

    //get report for owners accommodation
    @GetMapping(value = "/owner/{ownerId}/accommodation", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ArrayList<Report>> getAccommodationReport(@PathVariable Long ownerId ,
                                                                         @RequestParam Long accommodation) throws IOException {
        ArrayList<Report> data = service.getAccommodationReport(ownerId, accommodation);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

}
