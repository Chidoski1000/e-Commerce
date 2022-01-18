package com.example.demorestservice.repositories;

import com.example.demorestservice.entities.AppUser;
import com.example.demorestservice.entities.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

//    @Query("select * from feedback where complaint =?complaintId, ")
//    List<Feedback> getAllComplaintFeedback(Long complaintId);
}
