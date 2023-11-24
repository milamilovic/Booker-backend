package booker.BookingApp.service.interfaces;

import booker.BookingApp.dto.accommodation.AccommodationDTO;
import booker.BookingApp.model.accommodation.Filter;

import java.io.IOException;
import java.util.ArrayList;

public interface IAccommodationService {

    ArrayList<AccommodationDTO> findAll() throws IOException;

    AccommodationDTO findOne(Long id) throws IOException;

    AccommodationDTO create(AccommodationDTO accommodation) throws Exception;

    AccommodationDTO update(AccommodationDTO accommodation) throws Exception;

    void delete(Long id);

    ArrayList<AccommodationDTO> findOwnersActiveAccommodations(Long ownerId);

    void removeFavoriteAccommodation(Long userId, Long accommodationId);

    ArrayList<AccommodationDTO> findUnapprovedAccommodations();

    ArrayList<AccommodationDTO> findGuestsFavouriteAccommodations(Long guestId);

    ArrayList<AccommodationDTO> search(String startDate, String endDate, String location, int people);

    ArrayList<AccommodationDTO> findAllOwnersAccommodations(Long ownerId);

    ArrayList<AccommodationDTO> applyFilters(ArrayList<AccommodationDTO> accommodations, Filter filter);
}