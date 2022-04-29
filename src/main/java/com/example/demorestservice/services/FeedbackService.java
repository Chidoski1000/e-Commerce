package com.example.demorestservice.services;

import com.example.demorestservice.models.Feedback;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FeedbackService {

    Feedback addFeedbackToComplaint(Feedback feedback, Long complaintId) throws Exception;

    Boolean deleteFeedbackToComplaint(Long feedbackId);

    Feedback getAllFeedbackForComplaint(Long complaintId);

    Feedback getFeedback(Long feedBackId);

    List<Feedback> getAllFeedback();

    Feedback updateFeedbackForComplaint(Feedback feedback);


}
