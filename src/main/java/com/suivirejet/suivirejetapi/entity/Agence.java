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
@Table(name="T_AGENCE")
public class Agence {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="ID_AGENCE",nullable=false, unique=true)
    private int idAgence ;

    @Column(name = "LIBELLE",nullable = false)
    private String libelle  ;

    @ManyToOne(targetEntity = DirectionGenerale.class)
    @JoinColumn(name="ID_DIRECTION_GENERALE",referencedColumnName = "ID_DIRECTION_GENERALE")
    private DirectionGenerale directionGenerale ;

    public int getIdAgence() {
        return idAgence;
    }

    public void setIdAgence(int idAgence) {
        this.idAgence = idAgence;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public DirectionGenerale getDirectionGenerale() {
        return directionGenerale;
    }

    public void setIdDirectionGenerale(DirectionGenerale directionGenerale) {
        this.directionGenerale = directionGenerale;
    }
}
