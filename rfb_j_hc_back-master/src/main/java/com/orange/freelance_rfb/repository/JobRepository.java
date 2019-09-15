package com.orange.freelance_rfb.repository;

import com.orange.freelance_rfb.model.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository
        extends JpaRepository<Job, Long> {
}
