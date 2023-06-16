package com.emin.laboratuvar.repositories;

import com.emin.laboratuvar.models.Laborant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaborantRepository extends JpaRepository<Laborant, String> {
}