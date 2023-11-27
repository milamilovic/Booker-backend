package booker.BookingApp.service.interfaces;

import booker.BookingApp.dto.accommodation.AccommodationCommentDTO;
import booker.BookingApp.dto.accommodation.ReportAccommodationCommentDTO;
import booker.BookingApp.model.accommodation.AccommodationComment;

import java.util.List;

public interface IAccommodationCommentService {
    public AccommodationComment findOne(Long id);
    public List<AccommodationComment> findAll();
    public List<AccommodationComment> findAllForAccommodation(Long accommodationId);
    public void remove(Long id);
    public AccommodationCommentDTO create(AccommodationCommentDTO accommodationCommentDTO);
    public AccommodationCommentDTO update(AccommodationCommentDTO accommodationCommentDTO);
    public void delete(Long id);
    public ReportAccommodationCommentDTO report(ReportAccommodationCommentDTO reportAccommodationCommentDTO);
}
