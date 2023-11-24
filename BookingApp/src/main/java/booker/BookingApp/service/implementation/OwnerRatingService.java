package booker.BookingApp.service.implementation;

import booker.BookingApp.model.OwnerRating;
import booker.BookingApp.repository.OwnerRatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OwnerRatingService {
    @Autowired
    private OwnerRatingRepository ownerRatingRepository;

    public OwnerRating findOne(Long id) {
        return ownerRatingRepository.findById(id).orElse(null);
    }



    public List<OwnerRating> findAll() {
        return ownerRatingRepository.findAll();
    }

    public List<OwnerRating> findAllReported() {
        List<OwnerRating> reported = ownerRatingRepository.findAllReported();
        return reported;
    }

    public void delete(Long id) {
        ownerRatingRepository.deleteById(id);
    }

    public OwnerRating save(OwnerRating ownerRating) {
        return ownerRatingRepository.save(ownerRating);
    }
}
