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
@Table(name = "T_ROLE")
public class Role {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="ID_ROLE",nullable=false, unique=true)
    private int idRole ;

    @Column(name="LIBELLE", length=255, nullable=false, unique=false)
    private String libelle ;

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
