package demo.demo.service.impl;

import demo.demo.entity.Complaint;
import demo.demo.mapper.exception.ComplaintNotFoundException;
import demo.demo.repository.ComplaintRepo;
import demo.demo.service.ComplaintService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ComplaintServiceImpl implements ComplaintService {

    private final ComplaintRepo complaintRepo;

    @Override
    public List<Complaint> getAllComplaints() {
        return complaintRepo.findAll();
    }

    @Override
    public Complaint getSpecificComplaint(Long id) {
        return complaintRepo.findById(id).
                orElseThrow(() -> new ComplaintNotFoundException("Complaint by id: " + id + "was not found!"));

    }

    @Override
    public Complaint addNewComplaint(Complaint complaint) {
        return complaintRepo.save(complaint);
    }

    @Override
    public Complaint updateComplaint(Complaint complaint) {
        return complaintRepo.save(complaint);
    }

    @Override
    public void deleteComplaint(Long id) {
        complaintRepo.deleteById(id);
    }
}
