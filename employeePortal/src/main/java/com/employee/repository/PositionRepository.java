package com.employee.repository;

import com.employee.dto.PositionProjection;
import com.employee.entity.Position;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Position,Long> {
    Page<PositionProjection> findAllProjectedBy(Pageable pageable);
}
