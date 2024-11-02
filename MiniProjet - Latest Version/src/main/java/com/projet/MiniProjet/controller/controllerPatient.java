package com.projet.MiniProjet.controller;


import com.projet.MiniProjet.model.Analyse;
import com.projet.MiniProjet.model.Patient;
import com.projet.MiniProjet.service.ServicePatient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patient")
public class controllerPatient {
private final ServicePatient servicePatient;
@Autowired
    public controllerPatient(ServicePatient servicePatient){this.servicePatient=servicePatient;}
    @GetMapping(path="/get")
    public List<Patient> getAll(){return servicePatient.getPatient();}
    @GetMapping(value = "/get/{idPatient}")
    public Optional<Patient> getById(@PathVariable Long idPatient) {
        return servicePatient.getPatientById(idPatient);
    }
    @PostMapping(value = "/create/{idRapport}")
    public ResponseEntity<String> createPatient(@RequestBody Patient newPatient, @PathVariable long idRapport) {
        String resultMessage = servicePatient.createPatient(newPatient, idRapport);

        if (resultMessage.startsWith("Error")) {
            return new ResponseEntity<>(resultMessage, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(resultMessage, HttpStatus.CREATED);
        }
    }


    @DeleteMapping(value = "/delete/{idPatient}")
    public String deletePatient(@PathVariable Long idPatient) {
        boolean exist = servicePatient.deletePatient(idPatient);
        if (exist) {
            return "deleted ";
        } else {
            return "not deleted";
        }
    }

    @PutMapping("/saveOrUpdate")
    public ResponseEntity<Patient> saveOrUpdatePatient(@RequestBody Patient patient) {
        try {
            Patient savedPatient = servicePatient.saveOrUpdatePatient(patient);
            return new ResponseEntity<>(savedPatient, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
