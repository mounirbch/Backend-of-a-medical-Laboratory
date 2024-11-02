package com.projet.MiniProjet.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class RapportMedical {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idRapport;


    private String reportContent;
    @OneToOne(mappedBy = "rapportMedical", cascade = CascadeType.ALL)
    private Patient patient;

    public RapportMedical(){
    }

    public RapportMedical(String reportContent,Patient patient){
        this.reportContent=reportContent;
    this.patient= patient;
    }


    public Long getIdRapport() {
        return idRapport;
    }

    public void setIdRapport(Long idRapport) {
        this.idRapport = idRapport;
    }



    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    public String getReportContent() {
        return reportContent;
    }

    public void setReportContent(String reportContent) {
        this.reportContent = reportContent;
    }
}

