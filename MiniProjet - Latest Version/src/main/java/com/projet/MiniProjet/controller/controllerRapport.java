package com.projet.MiniProjet.controller;

import com.projet.MiniProjet.model.Patient;
import com.projet.MiniProjet.model.RapportMedical;
import com.projet.MiniProjet.service.ServicePatient;
import com.projet.MiniProjet.service.ServiceRapport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="rapport")
public class controllerRapport {
    private final ServiceRapport serviceRapport;
    @Autowired
    public controllerRapport(ServiceRapport serviceRapport){this.serviceRapport=serviceRapport;}
    @GetMapping(path="/patientrapport")
    public List<RapportMedical> getAll1(){return serviceRapport.getRapport();}

}
