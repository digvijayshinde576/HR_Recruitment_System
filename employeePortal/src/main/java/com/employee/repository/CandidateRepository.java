package com.employee.repository;

import com.employee.dto.CandidateProjection;
import com.employee.entity.Candidate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CandidateRepository extends JpaRepository<Candidate, Long> {
    Page<CandidateProjection> findAllProjectedBy(Pageable pageable);
}
