package com.employee.repository;

import com.employee.entity.SubCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubCategoryRepository extends JpaRepository<SubCategoryEntity,Long> {
}
