package demo.demo.service;

import demo.demo.entity.Complaint;

import java.util.List;

public interface ComplaintService {

    List<Complaint> getAllComplaints();

    Complaint getSpecificComplaint(Long id);

    Complaint addNewComplaint(Complaint complaint);

    Complaint updateComplaint(Complaint complaint);

    void deleteComplaint(Long id);
}
