package com.suivirejet.suivirejetapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Table(name="T_SUIVI_DOSSIER_AMO")
public class SuiviDossierAMO {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="ID_SUIVI_DOSSIER_AMO",nullable=false, unique=true)
    private int idSuiviDossierAMO ;

    @ManyToOne(targetEntity = NiveauSuivi.class)
    @JoinColumn(name="ID_NIVEAU_SUIVI",referencedColumnName = "ID_NIVEAU_SUIVI")
    private NiveauSuivi NiveauSuivi ;

    @Column(name="DATE_ENREGISTREMENT_DOSSIER_AMO")
    private Date DateEnregistrementDossierAMO ;

    @Column(name="DATE_ACTION_NIVEAU_SUIVI")
    private Date DateActionNiveauSuivi ;

    @ManyToOne(targetEntity = DossierAMO.class)
    @JoinColumn(name="ID_DOSSIER_AMO", referencedColumnName = "ID_DOSSIER_AMO")
    private DossierAMO dossierAMO ;

    @ManyToOne(targetEntity = Agent.class)
    @JoinColumn(name="ID_AGENT_ACTION",referencedColumnName = "ID_AGENT")
    private Agent AgentAction ;

    @Column(name="NUMERO_RECOMMANDE")
    private String NumeroRecommande ;

    @Column(name="NOM_FICHIER_ACTION")
    private String nomFichierAction ;
}
