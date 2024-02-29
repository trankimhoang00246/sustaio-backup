package com.codejava.course.repository;

import com.codejava.course.model.entity.CollabRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CollabRequestRepository extends JpaRepository<CollabRequest, Long> {
    List<CollabRequest> findAllByUser_Username(String username);
    List<CollabRequest> findAllByUser_UsernameAndStatus(@Param("username") String username,@Param("status") String status);
}
