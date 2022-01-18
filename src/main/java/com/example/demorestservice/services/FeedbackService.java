package com.example.demorestservice.services;

import com.example.demorestservice.entities.Feedback;
import com.example.demorestservice.entities.Product;
import org.springframework.data.domain.Page;
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
