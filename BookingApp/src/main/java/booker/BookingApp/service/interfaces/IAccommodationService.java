package booker.BookingApp.service.interfaces;

import booker.BookingApp.dto.accommodation.AccommodationListingDTO;
import booker.BookingApp.dto.accommodation.CreateAccommodationDTO;
import booker.BookingApp.dto.accommodation.FavouriteAccommodationDTO;
import booker.BookingApp.dto.accommodation.AccommodationViewDTO;
import booker.BookingApp.model.accommodation.Accommodation;
import booker.BookingApp.model.accommodation.Filter;
import booker.BookingApp.model.accommodation.Image;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface IAccommodationService {

    ArrayList<AccommodationListingDTO> findAll() throws IOException;

    AccommodationViewDTO findOne(Long id) throws IOException;

    AccommodationViewDTO create(CreateAccommodationDTO accommodation, List<MultipartFile> imagesFiles) throws Exception;

    AccommodationViewDTO update(AccommodationViewDTO accommodation) throws Exception;

    void delete(Long id);

    ArrayList<AccommodationListingDTO> findOwnersActiveAccommodations(Long ownerId);

    void removeFavoriteAccommodation(Long userId, Long accommodationId);

    ArrayList<AccommodationListingDTO> findUnapprovedAccommodations();

    ArrayList<FavouriteAccommodationDTO> findGuestsFavouriteAccommodations(Long guestId) throws IOException;

    ArrayList<AccommodationListingDTO> search(String startDate, String endDate, String location, int people);

    ArrayList<AccommodationListingDTO> findAllOwnersAccommodations(Long ownerId);

    ArrayList<AccommodationListingDTO> applyFilters(ArrayList<AccommodationListingDTO> accommodations, Filter filter);


    ArrayList<Image> handleImageUpload(List<MultipartFile> imageFiles, Accommodation accommodation) throws IOException;
}
