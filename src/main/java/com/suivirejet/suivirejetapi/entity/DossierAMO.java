package com.suivirejet.suivirejetapi.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Table(name="T_DOSSIER_AMO")
public class DossierAMO {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="ID_DOSSIER_AMO",nullable=false, unique=true)
    private int idDossierAMO ;

    @Column(name="NUMERO_DOSSIER", nullable = false)
    private String numeroDossier ;

    @Column(name="NUMERO_IMMATRICULATION", nullable = false)
    private String numeroImmatriculation ;

    @ManyToOne(targetEntity = Agence.class)
    @JoinColumn(name="ID_AGENCE", referencedColumnName ="ID_AGENCE")
    private Agence Agence ;

    @ManyToOne(targetEntity = DirectionGenerale.class)
    @JoinColumn(name="ID_DIRECTION_GENERALE", referencedColumnName ="ID_DIRECTION_GENERALE")
    private DirectionGenerale DirectionGenerale ;

    @ManyToOne(targetEntity = Assure.class)
    @JoinColumn(name="ID_ASSURE", referencedColumnName ="ID_ASSURE")
    private Assure Assure ;

    @Column(name="NOM_ASSURE", nullable = false)
    private String NomAssure ;

    @Column(name="PRENOM_ASSURE", nullable = false)
    private String PrenomAssure ;

    @Column(name="NUMERO_TEL_ASSURE", nullable = false)
    private String NumeroTelAssure ;

    @Column(name="EMAIL_ASSURE", nullable = false)
    private String EmailAssure ;

    @Column(name="ADRESSE_ASSURE", nullable = false)
    private String AdresseAssure ;

    @Column(name="NOM_BENEFICIAIRE", nullable = false)
    private String NomBeneficiaire ;

    @Column(name="PRENOM_BENEFICIAIRE", nullable = false)
    private String PrenomBeneficiaire ;

    @Column(name="DATE_DEPOT", nullable = false)
    private Date DateDepot ;

    @Column(name="DATE_ENREGISTREMENT_AMO", nullable = false)
    private Date DateEnregistrementAMO ;

    @ManyToOne(targetEntity = TypeDossier.class)
    @JoinColumn(name="ID_TYPE_DOSSIER", referencedColumnName ="ID_TYPE_DOSSIER")
    private TypeDossier TypeDossier ;

    @ManyToOne(targetEntity = TypeSoin.class)
    @JoinColumn(name="ID_TYPE_SOIN", referencedColumnName ="ID_TYPE_SOIN")
    private TypeSoin TypeSoin ;

    @ManyToOne(targetEntity = TypeMotifRejetDossier.class)
    @JoinColumn(name="ID_TYPE_MOTIF_REJET_DOSSIER", referencedColumnName ="ID_TYPE_MOTIF_REJET_DOSSIER")
    private TypeMotifRejetDossier TypeMotifRejetDossier ;

    @ManyToOne(targetEntity = Agent.class)
    @JoinColumn(name="ID_AGENT_CREATION",referencedColumnName ="ID_AGENT")
    private Agent AgentCreation ;

    @Column(name="DATE_CREATION")
    private Date DateCreation ;

    @ManyToOne(targetEntity = Agent.class)
    @JoinColumn(name="ID_AGENT_MODIFICATION",referencedColumnName ="ID_AGENT")
    private Agent AgentModification ;

    @Column(name="DATE_MODIFICATION")
    private Date DateModification ;

    @ManyToOne(targetEntity = TracabiliteDossier.class)
    @JoinColumn(name="ID_TRACABILITE_DOSSIER",referencedColumnName = "ID_TRACABILITE_DOSSIER")
    private TracabiliteDossier tracabiliteDossier ;

    @Column(name="MONTANT")
    private Float Montant ;

    @ManyToOne(targetEntity = NiveauSuivi.class)
    @JoinColumn(name="ID_DERNIER_NIVEAU_SUIVI", referencedColumnName = "ID_NIVEAU_SUIVI")
    private NiveauSuivi DernierNiveauSuivi ;

    @Column(name="DATE_ACTION_DERNIER_NIVEAU")
    private Date DateActionDernierNiveau ;

    @Column(name="CODE_POSTAL")
    private String codePostal ;

    @Column(name="VILLE")
    private String ville ;


    public int getIdDossierAMO() {
        return idDossierAMO;
    }

    public void setIdDossierAMO(int idDossierAMO) {
        this.idDossierAMO = idDossierAMO;
    }

    public String getNumeroDossier() {
        return numeroDossier;
    }

    public void setNumeroDossier(String NumeroDossier) {
        numeroDossier = NumeroDossier;
    }

    public String getNumeroImmatriculation() {
        return numeroImmatriculation;
    }

    public void setNumeroImmatriculation(String numeroImmatriculation) {
        this.numeroImmatriculation = numeroImmatriculation;
    }

    public com.suivirejet.suivirejetapi.entity.Agence getAgence() {
        return Agence;
    }

    public void setAgence(com.suivirejet.suivirejetapi.entity.Agence agence) {
        Agence = agence;
    }

    public com.suivirejet.suivirejetapi.entity.DirectionGenerale getDirectionGenerale() {
        return DirectionGenerale;
    }

    public void setDirectionGenerale(com.suivirejet.suivirejetapi.entity.DirectionGenerale directionGenerale) {
        DirectionGenerale = directionGenerale;
    }

    public com.suivirejet.suivirejetapi.entity.Assure getAssure() {
        return Assure;
    }

    public void setAssure(com.suivirejet.suivirejetapi.entity.Assure assure) {
        Assure = assure;
    }

    public String getNomAssure() {
        return NomAssure;
    }

    public void setNomAssure(String nomAssure) {
        NomAssure = nomAssure;
    }

    public String getPrenomAssure() {
        return PrenomAssure;
    }

    public void setPrenomAssure(String prenomAssure) {
        PrenomAssure = prenomAssure;
    }

    public String getNumeroTelAssure() {
        return NumeroTelAssure;
    }

    public void setNumeroTelAssure(String numeroTelAssure) {
        NumeroTelAssure = numeroTelAssure;
    }

    public String getEmailAssure() {
        return EmailAssure;
    }

    public void setEmailAssure(String emailAssure) {
        EmailAssure = emailAssure;
    }

    public String getAdresseAssure() {
        return AdresseAssure;
    }

    public void setAdresseAssure(String adresseAssure) {
        AdresseAssure = adresseAssure;
    }

    public String getNomBeneficiaire() {
        return NomBeneficiaire;
    }

    public void setNomBeneficiaire(String nomBeneficiaire) {
        NomBeneficiaire = nomBeneficiaire;
    }

    public String getPrenomBeneficiaire() {
        return PrenomBeneficiaire;
    }

    public void setPrenomBeneficiaire(String prenomBeneficiaire) {
        PrenomBeneficiaire = prenomBeneficiaire;
    }

    public Date getDateDepot() {
        return DateDepot;
    }

    public void setDateDepot(Date dateDepot) {
        DateDepot = dateDepot;
    }

    public Date getDateEnregistrementAMO() {
        return DateEnregistrementAMO;
    }

    public void setDateEnregistrementAMO(Date dateEnregistrementAMO) {
        DateEnregistrementAMO = dateEnregistrementAMO;
    }

    public com.suivirejet.suivirejetapi.entity.TypeDossier getTypeDossier() {
        return TypeDossier;
    }

    public void setTypeDossier(com.suivirejet.suivirejetapi.entity.TypeDossier typeDossier) {
        TypeDossier = typeDossier;
    }

    public com.suivirejet.suivirejetapi.entity.TypeSoin getTypeSoin() {
        return TypeSoin;
    }

    public void setTypeSoin(com.suivirejet.suivirejetapi.entity.TypeSoin typeSoin) {
        TypeSoin = typeSoin;
    }

    public com.suivirejet.suivirejetapi.entity.TypeMotifRejetDossier getTypeMotifRejetDossier() {
        return TypeMotifRejetDossier;
    }

    public void setTypeMotifRejetDossier(com.suivirejet.suivirejetapi.entity.TypeMotifRejetDossier typeMotifRejetDossier) {
        TypeMotifRejetDossier = typeMotifRejetDossier;
    }

    public Agent getAgentCreation() {
        return AgentCreation;
    }

    public void setAgentCreation(Agent agentCreation) {
        AgentCreation = agentCreation;
    }

    public Date getDateCreation() {
        return DateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        DateCreation = dateCreation;
    }

    public Agent getAgentModification() {
        return AgentModification;
    }

    public void setAgentModification(Agent agentModification) {
        AgentModification = agentModification;
    }

    public Date getDateModification() {
        return DateModification;
    }

    public void setDateModification(Date dateModification) {
        DateModification = dateModification;
    }

    public Float getMontant() {
        return Montant;
    }

    public void setMontant(Float montant) {
        Montant = montant;
    }

    public NiveauSuivi getDernierNiveauSuivi() {
        return DernierNiveauSuivi;
    }

    public void setDernierNiveauSuivi(NiveauSuivi dernierNiveauSuivi) {
        DernierNiveauSuivi = dernierNiveauSuivi;
    }

    public Date getDateActionDernierNiveau() {
        return DateActionDernierNiveau;
    }

    public void setDateActionDernierNiveau(Date dateActionDernierNiveau) {
        DateActionDernierNiveau = dateActionDernierNiveau;
    }

    public TracabiliteDossier getTracabiliteDossier() {
        return tracabiliteDossier;
    }

    public void setTracabiliteDossier(TracabiliteDossier tracabiliteDossier) {
        this.tracabiliteDossier = tracabiliteDossier;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }
}
