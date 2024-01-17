package demo.demo.service;

import demo.demo.entity.Complaint;
import demo.demo.entity.enums.ComplaintStatus;

import java.util.List;

public interface ComplaintService {

    List<Complaint> getAllComplaints();

    Complaint getSpecificComplaint(Long id);

    void addNewComplaint(Complaint complaint);

    void updateComplaint(Long complaintId, String description, ComplaintStatus status);

    void deleteComplaint(Long id);

    List<Complaint> getAllAppUserComplaints(Long id);

    void deleteAppUserComplaint(Long id, Long appUserId);
}
