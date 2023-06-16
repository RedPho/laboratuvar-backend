package com.emin.laboratuvar.services;

import com.emin.laboratuvar.models.Hasta;
import com.emin.laboratuvar.repositories.HastaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class HastaService {

    @Autowired
    private HastaRepository hastaRepository;

    public Hasta store(String ad, String soyad, String tc) {
        Hasta hasta = new Hasta(ad, soyad, tc);
        return hastaRepository.save(hasta);
    }

    public Hasta getById(String id) {
        return hastaRepository.findById(id).get();
    }

    public ArrayList<Hasta> getByNameSurname(String name)
}
