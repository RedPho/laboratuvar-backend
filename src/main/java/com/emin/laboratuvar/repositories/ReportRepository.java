package com.emin.laboratuvar.repositories;

import com.emin.laboratuvar.models.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends JpaRepository<Report, String> {
}