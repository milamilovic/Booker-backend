package booker.BookingApp.service.implementation;

import booker.BookingApp.dto.commentsAndRatings.CreateOwnerRatingDTO;
import booker.BookingApp.dto.commentsAndRatings.OwnerRatingDTO;
import booker.BookingApp.model.commentsAndRatings.OwnerRating;
import booker.BookingApp.repository.OwnerRatingRepository;
import booker.BookingApp.service.interfaces.IOwnerRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OwnerRatingService implements IOwnerRatingService {
    @Autowired
    private OwnerRatingRepository ownerRatingRepository;
    @Override
    public OwnerRating findOne(Long id) {
        return ownerRatingRepository.findById(id).orElse(null);
    }

    @Override
    public List<OwnerRating> findAll() {
        return ownerRatingRepository.findAll();
    }
    @Override
    public List<OwnerRating> findAllReported() {
        List<OwnerRating> reported = ownerRatingRepository.findAllReported();
        return reported;
    }
    @Override
    public void delete(Long id) {
        ownerRatingRepository.deleteById(id);
    }

    @Override
    public CreateOwnerRatingDTO create(CreateOwnerRatingDTO ownerRatingDTO) {
        return ownerRatingDTO;
    }
//    @Override
//    public OwnerRating save(OwnerRating ownerRating) {
//        return ownerRatingRepository.save(ownerRating);
//    }

    @Override
    public OwnerRatingDTO update(OwnerRatingDTO ownerRatingDTO) {
        return ownerRatingDTO;
    }

    @Override
    public List<OwnerRating> getAllForOwner(Long ownerId) {
        return ownerRatingRepository.findAllForOwner(ownerId);
    }


}
