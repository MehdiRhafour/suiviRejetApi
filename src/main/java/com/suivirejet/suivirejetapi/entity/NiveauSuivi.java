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
@Table(name="T_NIVEAU_SUIVI")
public class NiveauSuivi {

    public static int SAISIE_REJET = 1 ;
    public static int SMS_NOTIF_REJET = 2 ;
    public static int EMAIL_NOTIF_REJET = 3 ;
    public static int SMS_RELANCE_REJET = 4 ;
    public static int ENVOIE_CONVOCATION = 5 ;
    public static int ENVOIE_VOIE_VOCALE = 6 ;
    public static int REMISE_ASSURE = 7 ;
    public static int ENVOIE_RECOMMANDE = 8 ;
    public static int ATTENTE_RECLAMATION = 9 ;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="ID_NIVEAU_SUIVI",nullable=false, unique=true)
    private int idNiveauSuivi ;

    @Column(name="LIBELLE",nullable = false)
    private String libelle ;
}
