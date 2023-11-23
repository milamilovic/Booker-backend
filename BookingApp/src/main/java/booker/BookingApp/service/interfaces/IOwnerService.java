package booker.BookingApp.service.interfaces;

import booker.BookingApp.model.Owner;

public interface IOwnerService {
    void findAll();
    void getOwnerById(Long ownerId);
    Owner create(Owner owner);
    Owner update(Owner owner);
    void delete(Long ownerId);
}
