package booker.BookingApp.service.implementation;

import booker.BookingApp.dto.accommodation.AccommodationCommentDTO;
import booker.BookingApp.dto.accommodation.ReportAccommodationCommentDTO;
import booker.BookingApp.model.accommodation.AccommodationComment;
import booker.BookingApp.repository.AccommodationCommentRepository;
import booker.BookingApp.service.interfaces.IAccommodationCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccommodationCommentService implements IAccommodationCommentService {
    @Autowired
    private AccommodationCommentRepository accommodationCommentRepository;

    @Override
    public AccommodationComment findOne(Long id) {
        return accommodationCommentRepository.findById(id).orElse(null);
    }

    @Override
    public List<AccommodationComment> findAll() {
        return accommodationCommentRepository.findAll();
    }

    @Override
    public List<AccommodationComment> findAllForAccommodation(Long accommodationId) {
        return accommodationCommentRepository.findAllForAccommodation(accommodationId);
    }

    @Override
    public void remove(Long id) {
        accommodationCommentRepository.deleteById(id);
    }

//    public AccommodationComment save(AccommodationComment accommodationComment) {
//        return accommodationCommentRepository.save(accommodationComment);
//    }

    @Override
    public AccommodationCommentDTO create(AccommodationCommentDTO accommodationComment) {
        return accommodationComment;
    }

    @Override
    public AccommodationCommentDTO update(AccommodationCommentDTO accommodationCommentDTO) {
        return accommodationCommentDTO;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void report(Long id) {
        AccommodationComment comment = accommodationCommentRepository.findById(id).orElseGet(null);
        comment.setReported(true);
        accommodationCommentRepository.save(comment);
    }


    @Override
    public AccommodationComment save(AccommodationComment accommodationComment) {
        return accommodationCommentRepository.save(accommodationComment);
    }

    @Override
    public List<AccommodationComment> findAllReported() {
        return accommodationCommentRepository.findAllReported();
    }
}
