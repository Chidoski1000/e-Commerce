package com.example.demorestservice.services.impl;

import com.example.demorestservice.models.Complaint;
import com.example.demorestservice.models.Feedback;
import com.example.demorestservice.repositories.ComplaintRepository;
import com.example.demorestservice.repositories.FeedbackRepository;
import com.example.demorestservice.services.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;
    @Autowired
    private ComplaintRepository complaintRepository;

    @Override
    public Feedback addFeedbackToComplaint(Feedback feedback, Long complaintId) throws Exception {
        Optional<Complaint> optionalComplaint = complaintRepository.findById(complaintId);
        if(optionalComplaint.isEmpty())
            throw new Exception("Complaint not found");
        Complaint complaint = optionalComplaint.get();
        feedback.setComplaint(complaint);
        return feedbackRepository.save(feedback);
    }

    @Override
    public Boolean deleteFeedbackToComplaint(Long feedbackId) {
        Feedback feedback = getFeedback(feedbackId);
        if (feedback != null) {
            feedbackRepository.delete(feedback);
            return true;
        }
        return false;
    }

    @Override
    public Feedback getAllFeedbackForComplaint(Long complaintId) {
        //TODO
        return null;
    }

    @Override
    public Feedback getFeedback(Long feedBackId) {
        return feedbackRepository.getById(feedBackId);
    }

    @Override
    public List<Feedback> getAllFeedback() {
        return feedbackRepository.findAll();
    }

    @Override
    public Feedback updateFeedbackForComplaint(Feedback feedback) {
        Feedback updateFeedback = getFeedback(feedback.getFeedbackID());
        updateFeedback.setFeedBackResponse(feedback.getFeedBackResponse());
        return feedbackRepository.save(updateFeedback);
    }
}
