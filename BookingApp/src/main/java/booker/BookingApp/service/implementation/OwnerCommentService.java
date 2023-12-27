package booker.BookingApp.service.implementation;

import booker.BookingApp.dto.commentsAndRatings.CreateOwnerCommentDTO;
import booker.BookingApp.dto.commentsAndRatings.OwnerCommentDTO;
import booker.BookingApp.model.commentsAndRatings.OwnerComment;
import booker.BookingApp.model.users.Guest;
import booker.BookingApp.model.users.Owner;
import booker.BookingApp.repository.OwnerCommentRepository;
import booker.BookingApp.repository.ReservationRepository;
import booker.BookingApp.repository.UserRepository;
import booker.BookingApp.service.interfaces.IOwnerCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OwnerCommentService implements IOwnerCommentService {
    @Autowired
    private OwnerCommentRepository ownerCommentRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public OwnerComment findOne(Long id) {
        return ownerCommentRepository.findById(id).orElse(null);
    }
    @Override
    public List<OwnerComment> findAll() {
        return ownerCommentRepository.findAll();
    }

    @Override
    public List<OwnerComment> findAllForOwner(Long ownerId) {
        return ownerCommentRepository.findAllForOwner(ownerId);
    }

    @Override
    public void remove(Long id) {
        ownerCommentRepository.deleteById(id);
    }


    @Override
    public OwnerCommentDTO create(CreateOwnerCommentDTO createOwnerCommentDTO) {
        OwnerComment ownerComment = new OwnerComment();
        ownerComment.setContent(createOwnerCommentDTO.getContent());
        ownerComment.setReported(false);
        ownerComment.setDate(new Date());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null) {
            Object principal = authentication.getPrincipal();

            if (principal instanceof Guest) {
                Guest user = (Guest) principal;
                if (reservationRepository.findAllForGuest(user.getId(), createOwnerCommentDTO.getOwnerId()).isEmpty()) {
                    throw new RuntimeException("Guest has no reservations. Commenting is not allowed.");
                }

                ownerComment.setGuest(user);
            } else {
                // Handle the case where the principal is not an instance of User
                throw new RuntimeException("Unexpected principal type: " + principal.getClass());
            }
        } else {
            // Handle the case where there is no authentication
            throw new RuntimeException("User not authenticated");
        }
        Owner owner = (Owner) userRepository.findById(createOwnerCommentDTO.getOwnerId()).orElseGet(null);
        ownerComment.setOwner(owner);

        ownerCommentRepository.save(ownerComment);
        OwnerCommentDTO ownerCommentDTO = OwnerCommentDTO.createFromOwnerComment(ownerComment);
        return ownerCommentDTO;
    }

    @Override
    public OwnerCommentDTO update(OwnerCommentDTO ownerCommentDTO) {
        return ownerCommentDTO;
    }

    @Override
    public void delete(Long id) {}

//     @Override
//     public OwnerComment save(OwnerComment ownerComment) {
//         return ownerCommentRepository.save(ownerComment);
//     }


    @Override
    public List<OwnerComment> findAllReported() {
        return ownerCommentRepository.findAllReported();
    }

    @Override
    public void report(Long id) {
        OwnerComment comment = ownerCommentRepository.findById(id).orElseGet(null);
        comment.setReported(true);
        ownerCommentRepository.save(comment);
    }


}
