package com.projet.MiniProjet.controller;

import com.projet.MiniProjet.model.Analyse;
import com.projet.MiniProjet.model.Patient;
import com.projet.MiniProjet.service.ServiceAnalyse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/analyse")
public class controllerAnalyse {
    private final ServiceAnalyse serviceAnalyse;

    @Autowired
    public controllerAnalyse(ServiceAnalyse serviceAnalyse) {
        this.serviceAnalyse = serviceAnalyse;
    }
    @GetMapping("/get")
    public List<Analyse> getAll() {
        return serviceAnalyse.getAnalyse();
    }

    @GetMapping(value = "/get/{idAnalyse}")
    public Optional<Analyse> getById(@PathVariable Long idAnalyse) {
        return serviceAnalyse.getAnalyseById(idAnalyse);
    }

    @DeleteMapping(value = "/delete/{idAnalyse}")
    public String deleteAnalyse(@PathVariable Long idAnalyse) {
        boolean exist = serviceAnalyse.deleteAnalyse(idAnalyse);
        if (exist) {
            return "deleted ";
        } else {
            return "not deleted";
        }
    }
   /* @PostMapping
    public Analyse creteAnalyse(@RequestBody Analyse newAnalyse){
        return serviceAnalyse.createAnalyse(newAnalyse);
    }*/

    @PutMapping("/saveOrUpdate")
    public ResponseEntity<Analyse> saveOrUpdateAnalyse(@RequestBody Analyse analyse) {
        try {
            Analyse savedAnalyse = serviceAnalyse.saveOrUpdateAnalyse(analyse);
            return new ResponseEntity<>(savedAnalyse, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping(value="/create/{idPatient}")
    public Analyse creteAnalyse( @RequestBody Analyse newAnalyse,@PathVariable long idPatient){
        return serviceAnalyse.createAnalyse(newAnalyse,idPatient);
    }

}


