package com.emin.laboratuvar.repositories;

import com.emin.laboratuvar.models.Laborant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LaborantRepository extends JpaRepository<Laborant, Long> {
    List<Laborant> findByFirstName(String firstName);
    List<Laborant> findByLastName(String lastName);
}