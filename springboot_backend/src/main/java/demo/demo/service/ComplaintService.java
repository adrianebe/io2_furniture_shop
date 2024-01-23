package demo.demo.service;

import demo.demo.entity.AppUser;
import demo.demo.entity.Complaint;
import demo.demo.entity.Order;
import demo.demo.entity.enums.ComplaintStatus;

import java.util.List;

public interface ComplaintService {

    List<Complaint> getAllComplaints();

    Complaint getComplaintById(Long complaintId);

    void createNewComplaint(AppUser appUser, Order order, Complaint complaint);

    void updateComplaint(Long complaintId, String response, ComplaintStatus status);

    void deleteComplaint(Long complaintId);

    List<Complaint> getAllAppUserComplaints(Long appUserId);

    void deleteAppUserComplaint(Long complaintId, Long appUserId);
}
