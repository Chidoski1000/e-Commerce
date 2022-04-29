package com.example.demorestservice.services;

import com.example.demorestservice.models.Complaint;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ComplaintService {

    Complaint addComplaint(Complaint complaint);

    Complaint getComplaint(Long complaintId);

    List<Complaint> getAllComplaint();

    Complaint updateComplaint(Complaint complaint);

    Boolean deleteComplaint(Long complaintId);

}
