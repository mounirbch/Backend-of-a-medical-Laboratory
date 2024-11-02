package com.projet.MiniProjet.service;

import com.projet.MiniProjet.model.Analyse;
import com.projet.MiniProjet.model.Patient;
import com.projet.MiniProjet.model.RapportMedical;
import com.projet.MiniProjet.repository.repositoryPatient;
import com.projet.MiniProjet.repository.repositoryRapport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
    public class ServicePatient {
        private final repositoryPatient patientRepo;
        private  final repositoryRapport rapportRepo;
        @Autowired
        public ServicePatient (repositoryPatient patientRepo,repositoryRapport rapportRepo){
            super();
            this.patientRepo=patientRepo;
            this.rapportRepo=rapportRepo;
        }
        public List<Patient> getPatient(){return patientRepo.findAll();}
    public Optional<Patient> getPatientById(Long idPatient){
        Optional<Patient> off = patientRepo.findById(idPatient);
        return off ;

    }
    public String createPatient(Patient newPatient, Long idRapport) {
        Optional<RapportMedical> rapportMedicalOptional = rapportRepo.findById(idRapport);

        if (rapportMedicalOptional.isPresent()) {
            RapportMedical rapportMedical = rapportMedicalOptional.get();
            newPatient.setRapportMedical(rapportMedical);
            patientRepo.save(newPatient);
            return "Patient created successfully!";
        } else {
            return "Error: RapportMedical with ID " + idRapport + " is existing";
        }
    }

    public boolean deletePatient(Long idPatient){
        Optional<Patient> Patient = patientRepo.findById(idPatient);
        if(Patient.isPresent()){
            patientRepo.deleteById(idPatient);
            return  true ;
        }else{
            return  false ;
        }
    }
    public Patient saveOrUpdatePatient(Patient patient) {
        Optional<Patient> Patient = patientRepo.findById(patient.getidPatient());
        if (Patient.isPresent()) {
            Optional<Patient> existingPatient = patientRepo.findById(patient.getidPatient());
            if (existingPatient.isPresent()) {
                // Update the existing patient
                Patient updatedPatient = existingPatient.get();
                updatePatientData(updatedPatient, patient);
                return patientRepo.save(updatedPatient);
            } else {
                // If the patient ID is provided but not found, you may want to handle this case accordingly
                throw new RuntimeException("Patient with ID " + patient.getidPatient() + " not found.");
            }
        } else {
            return patientRepo.save(patient);
        }
    }

    private void updatePatientData(Patient existingPatient, Patient newPatient) {

        existingPatient.setFirstName(newPatient.getFirstName());
        existingPatient.setLastName(newPatient.getLastName());
        existingPatient.setDateOfBirth(newPatient.getDateOfBirth());
        existingPatient.setGender(newPatient.getGender());
        existingPatient.setAddress(newPatient.getAddress());
        existingPatient.setPhoneNumber(newPatient.getPhoneNumber());
        existingPatient.setEmail(newPatient.getEmail());
        // You can add more fields to update as needed
    }
    }

