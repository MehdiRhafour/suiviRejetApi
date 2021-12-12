package com.suivirejet.suivirejetapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "T_TYPE_AFFECTATION")
public class TypeAffectation {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="ID_TYPE_AFFECTATION",nullable=false, unique=true)
    private int idTypeAffectation ;

    @Column(name="LIBELLE", length=255, nullable=false, unique=false)
    private String  libelle ;

    public int getIdTypeAffectation() {
        return idTypeAffectation;
    }

    public void setIdTypeAffectation(int idTypeAffectation) {
        this.idTypeAffectation = idTypeAffectation;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
