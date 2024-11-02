package com.projet.MiniProjet.model;

import jakarta.persistence.*;

import java.time.LocalDate;
@Table
@Entity
public class Analyse {
    @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAnalyse;

    @ManyToOne
    @JoinColumn(name = "idPatient",nullable=true)
    Patient patient;

    private LocalDate dateAnalyse;
    private String typeAnalyse;
    private String resultats;
    private String commentaireMedecin;
    private String statut;

    public Analyse() {

    }
    public Analyse(Patient patient, LocalDate dateAnalyse, String typeAnalyse,String resultats, String commentaireMedecin, String statut) {

        this.patient = patient;
        this.dateAnalyse = dateAnalyse;
        this.typeAnalyse = typeAnalyse;
        this.resultats = resultats;
        this.commentaireMedecin = commentaireMedecin;
        this.statut = statut;

    }




    public Long getIdAnalyse() {
        return idAnalyse;
    }

    public void setIdAnalyse(Long idAnalyse) {
        this.idAnalyse = idAnalyse;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public LocalDate getDateAnalyse() {
        return dateAnalyse;
    }

    public void setDateAnalyse(LocalDate dateAnalyse) {
        this.dateAnalyse = dateAnalyse;
    }

    public String getTypeAnalyse() {
        return typeAnalyse;
    }

    public void setTypeAnalyse(String typeAnalyse) {
        this.typeAnalyse = typeAnalyse;
    }

    public String getResultats() {
        return resultats;
    }

    public void setResultats(String resultats) {
        this.resultats = resultats;
    }

    public String getCommentaireMedecin() {
        return commentaireMedecin;
    }

    public void setCommentaireMedecin(String commentaireMedecin) {
        this.commentaireMedecin = commentaireMedecin;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

}

