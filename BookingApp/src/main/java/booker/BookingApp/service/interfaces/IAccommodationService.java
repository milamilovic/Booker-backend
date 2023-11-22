package booker.BookingApp.service.interfaces;

import booker.BookingApp.dto.accommodation.AccommodationListingDTO;
import booker.BookingApp.dto.accommodation.FavouriteAccommodationDTO;
import booker.BookingApp.model.accommodation.Accommodation;

import java.io.IOException;
import java.util.ArrayList;

public interface IAccommodationService {

    ArrayList<Accommodation> findAll() throws IOException;

    Accommodation findOne(Long id) throws IOException;

    Accommodation create(Accommodation accommodation) throws Exception;

    Accommodation update(Accommodation accommodation) throws Exception;

    void delete(Long id);

    ArrayList<AccommodationListingDTO> findOwnersActiveAccommodations(Long ownerId);

    void removeFavoriteAccommodation(Long userId, Long accommodationId);

    ArrayList<AccommodationListingDTO> findUnapprovedAccommodations();

    ArrayList<FavouriteAccommodationDTO> findGuestsFavouriteAccommodations(Long guestId);

    ArrayList<AccommodationListingDTO> search(String startDate, String endDate, String location, int people);

    ArrayList<AccommodationListingDTO> findAllOwnersAccommodations(Long ownerId);
}