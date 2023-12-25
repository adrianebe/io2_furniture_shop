package demo.demo.controller;

import demo.demo.entity.Complaint;
import demo.demo.repository.ComplaintRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/complaints")
public class ComplaintController {

    private final ComplaintRepo complaintRepo;

    public ComplaintController(ComplaintRepo complaintRepo) {
        this.complaintRepo = complaintRepo;
    }

    @GetMapping("get")
    public List<Complaint> getAllComplaints() {
        return complaintRepo.findAll();
    }

    @GetMapping("get/{complaintId}")
    public Optional<Complaint> getSpecificComplaint(@PathVariable Long complaintId) {
        return complaintRepo.findById(complaintId);
    }

    @PostMapping("add")
    public Complaint newComplaint(@RequestBody Complaint complaint) {
        return complaintRepo.save(complaint);
    }
}
