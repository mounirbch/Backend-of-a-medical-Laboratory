package com.projet.MiniProjet.service;

import com.projet.MiniProjet.model.Patient;
import com.projet.MiniProjet.model.RapportMedical;
import com.projet.MiniProjet.repository.repositoryPatient;
import com.projet.MiniProjet.repository.repositoryRapport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceRapport {
    private final repositoryRapport rapportRepo;
    @Autowired
    public ServiceRapport (repositoryRapport rapportRepo){
        super();
        this.rapportRepo=rapportRepo;
    }
    public List<RapportMedical> getRapport(){return rapportRepo.findAll();}
}

