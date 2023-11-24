package booker.BookingApp.service.implementation;

import booker.BookingApp.model.OwnerComment;
import booker.BookingApp.repository.OwnerCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OwnerCommentService {
    @Autowired
    private OwnerCommentRepository ownerCommentRepository;

    public OwnerComment findOne(Long id) {
        return ownerCommentRepository.findById(id).orElse(null);
    }

    public List<OwnerComment> findAll() {
        return ownerCommentRepository.findAll();
    }

    public void remove(Long id) {
        ownerCommentRepository.deleteById(id);
    }

    public OwnerComment save(OwnerComment ownerComment) {
        return ownerCommentRepository.save(ownerComment);
    }
}
