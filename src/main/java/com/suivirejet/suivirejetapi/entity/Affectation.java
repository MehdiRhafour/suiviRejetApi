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
@Table(name="T_AFFECTATION")
public class Affectation {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="ID_AFFECTATION",nullable=false, unique=true)
    private int idAffectation ;

    @Column(name="LIBELLE",nullable=false)
    private String libelle ;

    @ManyToOne(targetEntity = TypeAffectation.class)
    @JoinColumn(name ="ID_TYPE_AFFECTATION" ,referencedColumnName = "ID_TYPE_AFFECTATION")
    private TypeAffectation typeAffectation ;

    public int getIdAffectation() {
        return idAffectation;
    }

    public void setIdAffectation(int idAffectation) {
        this.idAffectation = idAffectation;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public TypeAffectation getTypeAffectation() {
        return typeAffectation;
    }

    public void setTypeAffectation(TypeAffectation typeAffectation) {
        this.typeAffectation = typeAffectation;
    }
}
