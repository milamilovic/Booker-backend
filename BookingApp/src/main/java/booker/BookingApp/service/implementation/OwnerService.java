package booker.BookingApp.service.implementation;

import booker.BookingApp.model.Owner;
import booker.BookingApp.service.interfaces.IOwnerService;

public class OwnerService implements IOwnerService {
    @Override
    public void findAll() {
        // Implementiraj logiku za dohvaćanje svih vlasnika
    }

    @Override
    public void getOwnerById(Long id) {
        // Implementiraj logiku za dohvaćanje vlasnika po ID-u
    }

    @Override
    public Owner create(Owner owner) {
        // Implementiraj logiku za stvaranje vlasnika
        return owner;
    }

    @Override
    public Owner update(Owner owner) {
        // Implementiraj logiku za ažuriranje vlasnika
        return owner;
    }

    @Override
    public void delete(Long id) {
        // Implementiraj logiku za brisanje vlasnika
    }
}
