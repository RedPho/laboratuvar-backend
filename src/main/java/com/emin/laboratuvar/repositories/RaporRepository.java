package com.emin.laboratuvar.repositories;

import com.emin.laboratuvar.models.Rapor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RaporRepository extends JpaRepository<Rapor, String> {
}