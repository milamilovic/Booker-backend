package booker.BookingApp.service.interfaces;

import booker.BookingApp.dto.accommodation.AccommodationRatingDTO;
import booker.BookingApp.model.accommodation.AccommodationRating;

import java.util.List;

public interface IAccommodationRatingService {
    public AccommodationRating findOne(Long id);
    public List<AccommodationRating> findAll();
    public List<AccommodationRating> findAllForAccommodation(Long accommodationId);
    public void remove (Long id);
    public AccommodationRatingDTO create(AccommodationRatingDTO ratingDTO);
    public AccommodationRatingDTO update(AccommodationRatingDTO ratingDTO);
    public void delete (Long id);
    public List<AccommodationRating> findAllReported();
}
