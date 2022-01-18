package com.example.demorestservice.services;

import com.example.demorestservice.entities.Complaint;
import com.example.demorestservice.entities.Product;
import org.springframework.data.domain.Page;
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
