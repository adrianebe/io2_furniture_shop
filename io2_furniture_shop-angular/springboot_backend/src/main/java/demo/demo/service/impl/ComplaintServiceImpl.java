package demo.demo.service.impl;

import demo.demo.entity.AppUser;
import demo.demo.entity.Complaint;
import demo.demo.entity.Order;
import demo.demo.entity.enums.ComplaintStatus;
import demo.demo.exception.custom.ComplaintNotFoundException;
import demo.demo.repository.ComplaintRepo;
import demo.demo.service.ComplaintService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ComplaintServiceImpl implements ComplaintService {

    private final ComplaintRepo complaintRepo;

    @Override
    public List<Complaint> getAllComplaints() {
        return complaintRepo.findAll();
    }

    @Override
    public Complaint getComplaintById(Long complaintId) {
        return complaintRepo.findById(complaintId).
                orElseThrow(() -> new ComplaintNotFoundException("Complaint by id: " + complaintId + " was not found!"));

    }

    @Override
    public void createNewComplaint(AppUser appUser, Order order, Complaint complaint) {

        complaint.setAppUser(appUser);
        complaint.setOrder(order);
        complaint.setStatus(ComplaintStatus.OPEN);
        complaint.setResponse("");

        complaintRepo.save(complaint);
    }

    @Override
    public void updateComplaint(Long complaintId, String response, ComplaintStatus status) {
        Complaint complaint = getComplaintById(complaintId);

        complaint.setResponse(response);
        complaint.setStatus(status);

        complaintRepo.save(complaint);
    }

    @Override
    public void deleteComplaint(Long complaintId) {
        complaintRepo.deleteById(complaintId);
    }

    @Override
    public List<Complaint> getAllAppUserComplaints(Long appUserId) {
        return complaintRepo.findAllByAppUserId(appUserId);
    }

    @Override
    public void deleteAppUserComplaint(Long complaintId, Long appUserId) {
        complaintRepo.deleteByIdAndAppUserId(complaintId, appUserId);
    }
}
