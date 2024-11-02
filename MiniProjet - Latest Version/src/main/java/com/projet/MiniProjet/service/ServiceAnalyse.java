package com.projet.MiniProjet.service;

import com.projet.MiniProjet.model.Analyse;
import com.projet.MiniProjet.model.Patient;
import com.projet.MiniProjet.model.RapportMedical;
import com.projet.MiniProjet.repository.repositoryAnalyse;
import com.projet.MiniProjet.repository.repositoryPatient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceAnalyse {
    private final repositoryAnalyse analyseRepo;
    private  repositoryPatient patientRepo;
    @Autowired
    public ServiceAnalyse (repositoryAnalyse analyseRepo,repositoryPatient patientRepo){
        super();
        this.analyseRepo=analyseRepo;
        this.patientRepo=patientRepo;
    }
    public List<Analyse> getAnalyse(){return analyseRepo.findAll();}

    public Optional<Analyse> getAnalyseById(Long idAnalyse){
        Optional<Analyse> off = analyseRepo.findById(idAnalyse);
        return off ;

    }
    public boolean deleteAnalyse(Long idAnalyse){
        Optional<Analyse> Analyse = analyseRepo.findById(idAnalyse);
        if(Analyse.isPresent()){
            analyseRepo.deleteById(idAnalyse);
            return  true ;
        }else{
            return  false ;
        }
    }
  /*  public Analyse createAnalyse(Analyse newAnalyse){

            return analyseRepo.save(newAnalyse);
    }*/


    public Analyse saveOrUpdateAnalyse(Analyse analyse) {
        Optional<Analyse> Analyse = analyseRepo.findById(analyse.getIdAnalyse());
        if (Analyse.isPresent()) {
            Optional<Analyse> existingAnalyse = analyseRepo.findById(analyse.getIdAnalyse());
            if (existingAnalyse.isPresent()) {
                Analyse updatedAnalyse = existingAnalyse.get();
                updatedAnalyseData(updatedAnalyse, analyse);
                return analyseRepo.save(updatedAnalyse);
            } else {
                // If the patient ID is provided but not found, you may want to handle this case accordingly
                throw new RuntimeException("Analyse with ID " + analyse.getIdAnalyse() + " not found.");
            }
        } else {
            return analyseRepo.save(analyse);
        }
    }
    private void updatedAnalyseData(Analyse existingAnalyse, Analyse newAnalyse) {
        existingAnalyse.setPatient(newAnalyse.getPatient());
        existingAnalyse.setDateAnalyse(newAnalyse.getDateAnalyse());
        existingAnalyse.setTypeAnalyse(newAnalyse.getTypeAnalyse());
        existingAnalyse.setResultats(newAnalyse.getResultats());
        existingAnalyse.setCommentaireMedecin(newAnalyse.getCommentaireMedecin());
        existingAnalyse.setStatut(newAnalyse.getStatut());
    }

    /*public String updateAnalyse(Analyse updateAnalyse){

        Long idAnalyse=updateAnalyse.getIdAnalyse();
        Optional <Analyse> stage= getAnalyseById(idAnalyse);
        if (stage.isPresent()){
            analyseRepo.save(updateAnalyse);

            return"offre de stage a été mis a jour";

        }
        else {
            analyseRepo.save(updateAnalyse);
            return "offre de stage a été créer avec succées";
        }
    }*/
    public Analyse createAnalyse(Analyse newAnalyse,Long idPatient){
        Optional<Patient> patient = patientRepo.findById(idPatient);
        if(patient.isPresent()){
            Patient patientME= patient.get();
            newAnalyse.setPatient(patientME);
            return analyseRepo.save(newAnalyse);

        }
        return analyseRepo.save(newAnalyse);    }

}

