package demo.demo.service.impl;

import demo.demo.entity.Complaint;
import demo.demo.entity.enums.ComplaintStatus;
import demo.demo.exception.ComplaintNotFoundException;
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
                orElseThrow(() -> new ComplaintNotFoundException("Complaint by id: " + id + " was not found!"));

    }

    @Override
    public void addNewComplaint(Complaint complaint) {
        complaintRepo.save(complaint);
    }

    @Override
    public void updateComplaint(Long complaintId, String description, ComplaintStatus status) {
        Complaint complaint = getSpecificComplaint(complaintId);

        complaint.setDescription(description);
        complaint.setStatus(status);

        complaintRepo.save(complaint);
    }

    @Override
    public void deleteComplaint(Long id) {
        complaintRepo.deleteById(id);
    }

    @Override
    public List<Complaint> getAllAppUserComplaints(Long appUserId) {
        return complaintRepo.findAllByAppUserId(appUserId);
    }

    @Override
    public void deleteAppUserComplaint(Long id, Long appUserId) {
        complaintRepo.deleteByIdAndAppUserId(id, appUserId);
    }
}
