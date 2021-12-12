package com.suivirejet.suivirejetapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="T_ASSURE")
public class Assure {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="ID_ASSURE",nullable=false, unique=true)
    private int idAssure ;

    @Column(name="NUMERO_CNSS",nullable=false, unique=true)
    private String numeroCNSS ;

    @Column(name="NOM")
    private String nom ;

    @Column(name="PRENOM")
    private String prenom ;

    @Column(name="EMAIL")
    private String email ;

    @Column(name="ADRESSE")
    private String adresse ;

    @Column(name="NUMERO_TEL", nullable=false,  unique=true)
    private String numeroTel ;

    public int getIdAssure() {
        return idAssure;
    }

    public void setIdAssure(int idAssure) {
        this.idAssure = idAssure;
    }

    public String getNumeroCNSS() {
        return numeroCNSS;
    }

    public void setNumeroCNSS(String numeroCNSS) {
        this.numeroCNSS = numeroCNSS;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNumeroTel() {
        return numeroTel;
    }

    public void setNumeroTel(String numeroTel) {
        this.numeroTel = numeroTel;
    }

    //    @OneToMany(targetEntity = TracabiliteDossier.class)
//    private  List<TracabiliteDossier> tracabiliteDossiers ;
}
