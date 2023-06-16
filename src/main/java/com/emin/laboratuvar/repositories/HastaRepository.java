package com.emin.laboratuvar.repositories;

import com.emin.laboratuvar.models.Hasta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HastaRepository extends JpaRepository<Hasta, Long>{
    List<Hasta> findByFirstName(String ad);
    List<Hasta> findByLastName(String soyad);
    List<Hasta> findByTCNo(String tc_kimlik_no);
}