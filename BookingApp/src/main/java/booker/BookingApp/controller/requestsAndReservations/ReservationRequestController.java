package booker.BookingApp.controller.requestsAndReservations;

import booker.BookingApp.dto.requestsAndReservations.ReservationRequestDTO;
import booker.BookingApp.model.accommodation.Filter;
import booker.BookingApp.service.interfaces.IReservationRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/requests")
@CrossOrigin(origins = "http://localhost:4200")
public class ReservationRequestController {
    @Autowired
    IReservationRequestService service;

    //create a request
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ReservationRequestDTO> insert(@RequestBody ReservationRequestDTO request) throws Exception {
        ReservationRequestDTO requestDTO = service.create(request);
        return new ResponseEntity<>(requestDTO, HttpStatus.OK);
    }

    //find all requests for owner
    @GetMapping(value = "/owner/{ownerId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ArrayList<ReservationRequestDTO>> findOwnersRequests(@PathVariable Long ownerId)
    {
        ArrayList<ReservationRequestDTO> requests = service.findOwnersRequests(ownerId);
        return new ResponseEntity<>(requests, HttpStatus.OK);
    }

    //find all requests for owner, filter by status
    @GetMapping(value = "/owner/{ownerId}/filter", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ArrayList<ReservationRequestDTO>> findOwnersRequestsByStatus(@PathVariable Long ownerId,
                                                                                       @RequestBody ArrayList<Filter> filters)
    {
        ArrayList<ReservationRequestDTO> requests = service.findOwnersRequests(ownerId);
        for(Filter filter : filters) {
            requests = service.applyFilters(requests, filter);
        }
        return new ResponseEntity<>(requests, HttpStatus.OK);
    }

    //   find all requests for owner, search
    //   /api/requests/owner/5/search/12.12.2023./Modern
    @GetMapping(value = "/owner/{ownerId}/search/{date}/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ArrayList<ReservationRequestDTO>> searchOwnersRequests(@PathVariable Long ownerId,
                                                                                 @PathVariable String date,
                                                                                 @PathVariable String name)
    {
        ArrayList<ReservationRequestDTO> requests = service.findOwnersRequests(ownerId);
        requests = service.search(date, name);
        return new ResponseEntity<>(requests, HttpStatus.OK);
    }

    //   searching accommodations with filters, path looks like
    //   /api/requests/owner/5/search/12.12.2023/Modern/filter
    //   and request body contains json with filter array
    @GetMapping(value = "/owner/{ownerId}/search/{date}/{name}/filter", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ArrayList<ReservationRequestDTO>> searchAndFilterOwnersRequests(@PathVariable Long ownerId,
                                                                                          @PathVariable String date,
                                                                                          @PathVariable String name,
                                                                                          @RequestBody ArrayList<Filter> filters)
    {
        ArrayList<ReservationRequestDTO> requests = service.findOwnersRequests(ownerId);
        requests = service.search(date, name);
        //TODO: make actual filter methods that service.applyFilter redirects to!!!
        for(Filter filter : filters) {
            requests = service.applyFilters(requests, filter);
        }
        return new ResponseEntity<>(requests, HttpStatus.OK);
    }

    //find all requests for guest
    @GetMapping(value = "/guest/{guestId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ArrayList<ReservationRequestDTO>> findGuestsRequests(@PathVariable Long guestId)
    {
        ArrayList<ReservationRequestDTO> requests = service.findGuestsRequests(guestId);
        return new ResponseEntity<>(requests, HttpStatus.OK);
    }

    //find all requests for guest, filter by status
    @GetMapping(value = "/guest/{guestId}/filter", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ArrayList<ReservationRequestDTO>> findGuestsRequestsByStatus(@PathVariable Long guestId,
                                                                                       @RequestBody ArrayList<Filter> filters)
    {
        ArrayList<ReservationRequestDTO> requests = service.findGuestsRequests(guestId);
        for(Filter filter : filters) {
            requests = service.applyFilters(requests, filter);
        }
        return new ResponseEntity<>(requests, HttpStatus.OK);
    }

    //   find all requests for guest, search
    //   /api/requests/guest/5/search?date=12.12.2023.&name=Modern
    @GetMapping(value = "/guest/{guestId}/search/{date}/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ArrayList<ReservationRequestDTO>> searchGuestsRequests(@PathVariable Long guestId,
                                                                                 @PathVariable String date,
                                                                                 @PathVariable String name)
    {
        ArrayList<ReservationRequestDTO> requests = service.findGuestsRequests(guestId);
        requests = service.search(date, name);
        return new ResponseEntity<>(requests, HttpStatus.OK);
    }

    //   searching accommodations with filters, path looks like
    //   /api/requests/guest/5/search?date=12.12.2023.&name=Modern?status=WAITING
    //   and request body contains json with filter array
    @GetMapping(value = "/guest/{guestId}/search/{date}/{name}/filter", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ArrayList<ReservationRequestDTO>> searchAndFilterGuestsRequests(@PathVariable Long guestId,
                                                                                          @PathVariable String date,
                                                                                          @PathVariable String name,
                                                                                          @RequestBody ArrayList<Filter> filters)
    {
        ArrayList<ReservationRequestDTO> requests = service.findGuestsRequests(guestId);
        requests = service.search(date, name);
        //TODO: make actual filter methods that service.applyFilter redirects to!!!
        for(Filter filter : filters) {
            requests = service.applyFilters(requests, filter);
        }
        return new ResponseEntity<>(requests, HttpStatus.OK);
    }

    //cancel request for guest
    @DeleteMapping(value = "/guest/{guestId}/cancel-request/{requestId}")
    public ResponseEntity<Void> cancelRequest(@PathVariable Long guestId, @PathVariable Long requestId) {
        service.cancelRequest(guestId, requestId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    //accept or decline request for owner
    @PutMapping(value = "/owner/{ownerId}/{requestId}/{accept}")
    public ResponseEntity<Void> declineAccommodation(@PathVariable Long ownerId,
                                                     @PathVariable Long requestId,
                                                     @PathVariable boolean accept) {
        service.acceptOrDeclineRequest(ownerId, requestId, accept);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
