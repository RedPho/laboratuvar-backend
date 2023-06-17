package com.emin.laboratuvar.repositories;

import com.emin.laboratuvar.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>{
    List<Patient> findByFirstName(String firstName);
    List<Patient> findByLastName(String lastName);
    List<Patient> findByTcNo(String tcNo);
}