package com.projet.MiniProjet.model;

import jakarta.persistence.*;


import java.time.LocalDate;


@Entity
public class Patient {
    @Id
    @GeneratedValue
    private Long idPatient;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String gender;
    private String address;
    private String phoneNumber;
    private String email;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idRapport", referencedColumnName = "idRapport")
    public RapportMedical rapportMedical;



    public Patient() {

    }



    public Patient(String firstName, String lastName, LocalDate dateOfBirth, String gender,
                   String address, String phoneNumber, String email,RapportMedical rapportMedical) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.rapportMedical= rapportMedical;


    }

   public Long getidPatient(){return idPatient;}
    public void setidPatient(Long idPatient){this.idPatient=idPatient;}
    public RapportMedical getRapportMedical() {
        return rapportMedical;
    }

    public void setRapportMedical(RapportMedical rapportMedical) {
        this.rapportMedical = rapportMedical;
    }




    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
