package booker.BookingApp.service.implementation;

import booker.BookingApp.dto.commentsAndRatings.OwnerCommentDTO;
import booker.BookingApp.dto.commentsAndRatings.ReportOwnerCommentDTO;
import booker.BookingApp.model.commentsAndRatings.OwnerComment;
import booker.BookingApp.repository.OwnerCommentRepository;
import booker.BookingApp.service.interfaces.IOwnerCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OwnerCommentService implements IOwnerCommentService {
    @Autowired
    private OwnerCommentRepository ownerCommentRepository;

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
    public OwnerCommentDTO create(OwnerCommentDTO ownerCommentDTO) {
        return ownerCommentDTO;
    }

    @Override
    public OwnerCommentDTO update(OwnerCommentDTO ownerCommentDTO) {
        return ownerCommentDTO;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<OwnerComment> findAllReported() {
        return ownerCommentRepository.findAllReported();
    }

    @Override
    public ReportOwnerCommentDTO report(ReportOwnerCommentDTO reportOwnerCommentDTO) {
        return reportOwnerCommentDTO;
    }

    //public OwnerComment save(OwnerComment ownerComment) {
        //return ownerCommentRepository.save(ownerComment);
    //}
}
