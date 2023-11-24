package booker.BookingApp.service.implementation;

import booker.BookingApp.model.accommodation.AccommodationComment;
import booker.BookingApp.repository.AccommodationCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccommodationCommentService {
    @Autowired
    private AccommodationCommentRepository accommodationCommentRepository;

    public AccommodationComment findOne(Long id) {
        return accommodationCommentRepository.findById(id).orElse(null);
    }


    public List<AccommodationComment> findAll() {
        return accommodationCommentRepository.findAll();
    }

    public List<AccommodationComment> findAllForAccommodation(Long accommodationId) {
        return accommodationCommentRepository.findAllForAccommodation(accommodationId);
    }

    public void remove(Long id) {
        accommodationCommentRepository.deleteById(id);
    }

    public AccommodationComment save(AccommodationComment accommodationComment) {
        return accommodationCommentRepository.save(accommodationComment);
    }
}
