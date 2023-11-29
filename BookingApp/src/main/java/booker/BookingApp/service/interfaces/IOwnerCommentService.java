package booker.BookingApp.service.interfaces;

import booker.BookingApp.dto.commentsAndRatings.OwnerCommentDTO;
import booker.BookingApp.dto.commentsAndRatings.ReportOwnerCommentDTO;
import booker.BookingApp.model.commentsAndRatings.OwnerComment;

import java.util.List;

public interface IOwnerCommentService {
    public OwnerComment findOne(Long id);
    public List<OwnerComment> findAll();
    public List<OwnerComment> findAllForOwner(Long ownerId);
    public void remove(Long id);
    public OwnerCommentDTO create(OwnerCommentDTO ownerCommentDTO);
    public OwnerCommentDTO update(OwnerCommentDTO ownerCommentDTO);
    public void delete(Long id);
    public List<OwnerComment> findAllReported();
    public void report(Long id);
}
