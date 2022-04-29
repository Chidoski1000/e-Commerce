package com.example.demorestservice.repositories;

import com.example.demorestservice.models.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

//    @Query("select * from feedback where complaint =?complaintId, ")
//    List<Feedback> getAllComplaintFeedback(Long complaintId);
}
