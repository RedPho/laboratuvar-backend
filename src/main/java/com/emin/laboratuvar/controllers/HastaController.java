package com.emin.laboratuvar.controllers;

import com.emin.laboratuvar.services.HastaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class HastaController {
    @Autowired
    private HastaService hastaService;
}
