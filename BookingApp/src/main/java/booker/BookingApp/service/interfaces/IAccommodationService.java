//package booker.BookingApp.service.interfaces;
//
//import booker.BookingApp.dto.accommodation.AccommodationListingDTO;
//import booker.BookingApp.dto.accommodation.FavouriteAccommodationDTO;
//import booker.BookingApp.dto.accommodation.WholeAccommodationDTO;
//import booker.BookingApp.model.accommodation.Accommodation;
//import booker.BookingApp.model.accommodation.Amenity;
//import booker.BookingApp.model.accommodation.Filter;
//
//import java.io.IOException;
//import java.util.ArrayList;
//
//public interface IAccommodationService {
//
//    ArrayList<WholeAccommodationDTO> findAll() throws IOException;
//
//    WholeAccommodationDTO findOne(Long id) throws IOException;
//
//    WholeAccommodationDTO create(Accommodation accommodation) throws Exception;
//
//    WholeAccommodationDTO update(Accommodation accommodation) throws Exception;
//
//    void delete(Long id);
//
//    ArrayList<AccommodationListingDTO> findOwnersActiveAccommodations(Long ownerId);
//
//    void removeFavoriteAccommodation(Long userId, Long accommodationId);
//
//    ArrayList<AccommodationListingDTO> findUnapprovedAccommodations();
//
//    ArrayList<FavouriteAccommodationDTO> findGuestsFavouriteAccommodations(Long guestId);
//
//    ArrayList<AccommodationListingDTO> search(String startDate, String endDate, String location, int people);
//
//    ArrayList<AccommodationListingDTO> findAllOwnersAccommodations(Long ownerId);
//
//    ArrayList<AccommodationListingDTO> applyFilters(ArrayList<AccommodationListingDTO> accommodations, Filter filter);
//}