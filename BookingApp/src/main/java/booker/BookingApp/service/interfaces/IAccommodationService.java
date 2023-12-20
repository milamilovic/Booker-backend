package booker.BookingApp.service.interfaces;

import booker.BookingApp.dto.accommodation.AccommodationListingDTO;
import booker.BookingApp.dto.accommodation.CreateAccommodationDTO;
import booker.BookingApp.dto.accommodation.FavouriteAccommodationDTO;
import booker.BookingApp.dto.accommodation.AccommodationViewDTO;
import booker.BookingApp.model.accommodation.Accommodation;
import booker.BookingApp.enums.AccommodationType;
import booker.BookingApp.enums.PriceType;
import booker.BookingApp.model.accommodation.Filter;
import booker.BookingApp.model.accommodation.Image;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public interface IAccommodationService {

    ArrayList<AccommodationListingDTO> findAll() throws IOException;

    AccommodationViewDTO findOne(Long id) throws IOException;

    AccommodationViewDTO create(CreateAccommodationDTO accommodation) throws Exception;

    AccommodationViewDTO update(AccommodationViewDTO accommodation) throws Exception;

    void delete(Long id);

    ArrayList<AccommodationListingDTO> findOwnersActiveAccommodations(Long ownerId);

    void removeFavoriteAccommodation(Long userId, Long accommodationId);

    ArrayList<AccommodationListingDTO> findAllUnapprovedAccommodations();

    ArrayList<FavouriteAccommodationDTO> findGuestsFavouriteAccommodations(Long guestId) throws IOException;

    ArrayList<AccommodationListingDTO> search(String startDate, String endDate, String location, int people);

    ArrayList<AccommodationListingDTO> findAllOwnersAccommodations(Long ownerId);


    void uploadAccommodationPictures(Long accommodationId, MultipartFile image) throws IOException;

    ArrayList<AccommodationListingDTO> applyFilters(ArrayList<AccommodationListingDTO> accommodations, Filter filter) throws IOException;

    ArrayList<AccommodationListingDTO> filterTypes(ArrayList<AccommodationListingDTO> accommodations, ArrayList<AccommodationType> adequateTypes);

    double findPriceForDateRange(Long id, Date startDate, Date endDate, int numOfGuests);

    double findUnitPrice(Long id, Date startDate, Date endDate, int numOfGuests);

    PriceType getAccommodationPriceType(Long accommodationId);

    void deleteImage(Long accommodationId, Long imageId);

    void uploadImage(Long accommodationId, MultipartFile image) throws IOException;
}
