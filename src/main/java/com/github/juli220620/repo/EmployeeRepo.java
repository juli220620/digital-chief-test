package com.github.juli220620.repo;

import com.github.juli220620.model.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<EmployeeEntity, Long> {

    List<EmployeeEntity> findAllByCompanyId(long companyId);
}
