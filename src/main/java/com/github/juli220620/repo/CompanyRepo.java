package com.github.juli220620.repo;

import com.github.juli220620.model.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepo extends JpaRepository<CompanyEntity, Long> {
}