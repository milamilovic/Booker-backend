package booker.BookingApp.controller.users;


import booker.BookingApp.model.users.Owner;
import booker.BookingApp.service.implementation.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

public class OwnerController {
    private final OwnerService ownerService;

    @Autowired
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping("/findAll")
    public void getAllOwners() {
        // Pozovi metodu findAll() iz ownerService-a
        ownerService.findAll();
    }

    @GetMapping("/{ownerId}")
    public void getOwner(@PathVariable Long ownerId) {
        // Pozovi metodu getOwnerById() iz ownerService-a
        ownerService.getOwnerById(ownerId);
    }

    @PostMapping("/create")
    public Owner createOwner(@RequestBody Owner owner) {
        // Pozovi metodu create() iz ownerService-a i vrati novog vlasnika
        return ownerService.create(owner);
    }

    @PutMapping("/{ownerId}")
    public Owner updateOwner(@PathVariable Long ownerId, @RequestBody Owner owner) throws Exception {
        // Pozovi metodu update() iz ownerService-a i vrati ažuriranog vlasnika
        return ownerService.update(owner);
    }

    @DeleteMapping("/{ownerId}")
    public void deleteOwner(@PathVariable Long ownerId) {
        // Pozovi metodu delete() iz ownerService-a
        ownerService.delete(ownerId);
    }
}

