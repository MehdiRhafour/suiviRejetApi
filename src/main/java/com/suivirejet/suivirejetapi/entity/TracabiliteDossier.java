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
@Table(name="T_TRACABILITE_DOSSIER")
public class TracabiliteDossier {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID_TRACABILITE_DOSSIER",nullable=false)
    private int idTracabiliteDossier ;

    @Column(name="NUMERO_DOSSIER", nullable = false)
    private String numeroDossier ;

    @Column(name="NUMERO_IMMATRICULATION", nullable = false)
    private String numeroImmatriculation ;

    @ManyToOne(targetEntity = Agence.class)
    @JoinColumn(name="ID_AGENCE", referencedColumnName ="ID_AGENCE")
    private Agence agence ;

    @ManyToOne(targetEntity = DirectionGenerale.class)
    @JoinColumn(name="ID_DIRECTION_GENERALE", referencedColumnName ="ID_DIRECTION_GENERALE")
    private DirectionGenerale directionGenerale ;

    @ManyToOne(targetEntity = TypeDossier.class)
    @JoinColumn(name="ID_TYPE_DOSSIER", referencedColumnName ="ID_TYPE_DOSSIER")
    private TypeDossier typeDossier ;

    @ManyToOne(targetEntity = TypeSoin.class)
    @JoinColumn(name="ID_TYPE_SOIN", referencedColumnName ="ID_TYPE_SOIN")
    private TypeSoin typeSoin ;

    @ManyToOne(targetEntity = Assure.class)
    @JoinColumn(name="ID_ASSURE", referencedColumnName ="ID_ASSURE")
    private Assure assure ;

    @Column(name="NUMERO_TEL_ASSURE", nullable = false)
    private String numeroTelAssure ;

    @Column(name="EMAIL_ASSURE", nullable = false)
    private String emailAssure ;

    @Column(name="ADRESSE_ASSURE", nullable = false)
    private String adresseAssure ;

    @Column(name="NOM_BENEFICIAIRE", nullable = false)
    private String nomBeneficiaire ;

    @Column(name="PRENOM_BENEFICIAIRE", nullable = false)
    private String prenomBeneficiaire ;

    @Column(name="DATE_DEPOT", nullable = false)
    private Date dateDepot ;

    @ManyToOne(targetEntity = EtatDossierTracabilite.class)
    @JoinColumn(name="ID_ETAT_DOSSIER_TRACABILITE", referencedColumnName ="ID_ETAT_DOSSIER_TRACABILITE")
    private EtatDossierTracabilite etatDossierTracabilite ;

    @Column(name="MONTANT")
    private Float montant ;

    @Column(name="CODE_POSTAL")
    private String codePostal ;

    @Column(name="VILLE")
    private String ville ;

    public int getIdTracabiliteDossier() {
        return idTracabiliteDossier;
    }

    public void setIdTracabiliteDossier(int idTracabiliteDossier) {
        this.idTracabiliteDossier = idTracabiliteDossier;
    }

    public String getNumeroDossier() {
        return numeroDossier;
    }

    public void setNumeroDossier(String numeroDossier) {
        this.numeroDossier = numeroDossier;
    }

    public String getNumeroImmatriculation() {
        return numeroImmatriculation;
    }

    public void setNumeroImmatriculation(String numeroImmatriculation) {
        this.numeroImmatriculation = numeroImmatriculation;
    }

    public Agence getAgence() {
        return agence;
    }

    public void setAgence(Agence agence) {
        this.agence = agence;
    }

    public DirectionGenerale getDirectionGenerale() {
        return directionGenerale;
    }

    public void setDirectionGenerale(DirectionGenerale directionGenerale) {
        this.directionGenerale = directionGenerale;
    }

    public TypeDossier getTypeDossier() {
        return typeDossier;
    }

    public void setTypeDossier(TypeDossier typeDossier) {
        this.typeDossier = typeDossier;
    }

    public TypeSoin getTypeSoin() {
        return typeSoin;
    }

    public void setTypeSoin(TypeSoin typeSoin) {
        this.typeSoin = typeSoin;
    }

    public Assure getAssure() {
        return assure;
    }

    public void setAssure(Assure assure) {
        this.assure = assure;
    }

    public String getNumeroTelAssure() {
        return numeroTelAssure;
    }

    public void setNumeroTelAssure(String numeroTelAssure) {
        this.numeroTelAssure = numeroTelAssure;
    }

    public String getEmailAssure() {
        return emailAssure;
    }

    public void setEmailAssure(String emailAssure) {
        this.emailAssure = emailAssure;
    }

    public String getAdresseAssure() {
        return adresseAssure;
    }

    public void setAdresseAssure(String adresseAssure) {
        this.adresseAssure = adresseAssure;
    }

    public String getNomBeneficiaire() {
        return nomBeneficiaire;
    }

    public void setNomBeneficiaire(String nomBeneficiaire) {
        this.nomBeneficiaire = nomBeneficiaire;
    }

    public String getPrenomBeneficiaire() {
        return prenomBeneficiaire;
    }

    public void setPrenomBeneficiaire(String prenomBeneficiaire) {
        this.prenomBeneficiaire = prenomBeneficiaire;
    }

    public Date getDateDepot() {
        return dateDepot;
    }

    public void setDateDepot(Date dateDepot) {
        this.dateDepot = dateDepot;
    }

    public EtatDossierTracabilite getEtatDossierTracabilite() {
        return etatDossierTracabilite;
    }

    public void setEtatDossierTracabilite(EtatDossierTracabilite etatDossierTracabilite) {
        this.etatDossierTracabilite = etatDossierTracabilite;
    }

    public Float getMontant() {
        return montant;
    }

    public void setMontant(Float montant) {
        this.montant = montant;
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
