package com.emin.laboratuvar.repositories;

import com.emin.laboratuvar.models.Laborant;
import com.emin.laboratuvar.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LaborantRepository extends JpaRepository<Laborant, String> {
    List<Patient> findByFirstName(String firstName);
    List<Patient> findByLastName(String lastName);
}