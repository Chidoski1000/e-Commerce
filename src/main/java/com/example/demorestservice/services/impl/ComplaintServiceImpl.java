package com.example.demorestservice.services.impl;

import com.example.demorestservice.entities.Complaint;
import com.example.demorestservice.entities.Product;
import com.example.demorestservice.repositories.ComplaintRepository;
import com.example.demorestservice.services.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComplaintServiceImpl implements ComplaintService {

    @Autowired
    private ComplaintRepository complaintRepository;

    @Override
    public Complaint addComplaint(Complaint complaint) {
        return complaintRepository.save(complaint);
    }

    @Override
    public Complaint getComplaint(Long complaintId) {
        Optional<Complaint> complaint = complaintRepository.findById(complaintId);
        return complaint.orElse(null);
    }

    @Override
    public List<Complaint> getAllComplaint() {
        return complaintRepository.findAll();
    }

    @Override
    public Complaint updateComplaint(Complaint complaint) {
        Complaint complaint1 = getComplaint(complaint.getComplaintId());
        if(complaint1 != null){
            complaint1.setComplaintDescription(complaint.getComplaintDescription());
            return complaintRepository.save(complaint1);
        }
        return null;
    }

    @Override
    public Boolean deleteComplaint(Long complaintId) {
        Complaint complaint1 = getComplaint(complaintId);
        if(complaint1 != null){
            complaintRepository.delete(complaint1);
        }
        return null;
    }
}
