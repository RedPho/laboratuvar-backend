package com.emin.laboratuvar.repositories;

import com.emin.laboratuvar.models.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {

    List<Report> findByPatientFirstNameContaining(String firstName);
    List<Report> findByPatientLastNameContaining(String lastName);
    Report findByPatientTcNo(String tcNo);
}