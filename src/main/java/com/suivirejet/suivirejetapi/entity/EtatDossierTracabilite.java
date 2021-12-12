package com.suivirejet.suivirejetapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Table(name="T_ETAT_DOSSIER_TRACABILITE")
public class EtatDossierTracabilite {

    public static final int ETAT_REJET = 1 ;
    public static final int ETAT_A_REEXPEDIER_AGENCE_ASSURE = 2 ;
    public static final int ETAT_REEXPEDIER_AGENCE_ASSURE = 3 ;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="ID_ETAT_DOSSIER_TRACABILITE",nullable=false, unique=true)
    private int idEtatDossierTracabilite ;

    @Column(name="LIBELLE")
    private String libelle ;

    public int getIdEtatDossierTracabilite() {
        return idEtatDossierTracabilite;
    }

    public void setIdEtatDossierTracabilite(int idEtatDossierTracabilite) {
        this.idEtatDossierTracabilite = idEtatDossierTracabilite;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
