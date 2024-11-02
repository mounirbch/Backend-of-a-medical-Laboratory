package com.projet.MiniProjet.repository;

import com.projet.MiniProjet.model.Patient;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface  repositoryPatient extends JpaRepository<Patient,Long> {

}
