package com.projet.MiniProjet.repository;

import com.projet.MiniProjet.model.RapportMedical;
import org.springframework.data.jpa.repository.JpaRepository;

public interface repositoryRapport extends JpaRepository <RapportMedical,Long> {
}
