package booker.BookingApp.controller;

import booker.BookingApp.model.Guest;
import booker.BookingApp.service.implementation.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/guests")
public class GuestController {
    private final GuestService guestService;

    @Autowired
    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }

    @GetMapping("/findAll")
    public void getAllGuests() {
        //return guestService.findAll();
    }

    @GetMapping("/{guestId}")
    public void getGuest(@PathVariable Long guestId) {
        //return guestService.getGuestById(guestId);
    }

    @PostMapping("/create")
    public Guest createGuest(@RequestBody Guest guest) {
        return guestService.create(guest);
    }

    @PutMapping("/{guestId}")
    public Guest updateGuest(@PathVariable Long guestId, @RequestBody Guest guest) throws Exception {
        return guestService.update(guest);
    }

    @DeleteMapping("/{guestId}")
    public void deleteGuest(@PathVariable Long guestId) {
        guestService.delete(guestId);
    }
}
