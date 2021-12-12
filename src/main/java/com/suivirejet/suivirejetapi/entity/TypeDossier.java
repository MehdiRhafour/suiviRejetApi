package com.suivirejet.suivirejetapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
    @Table(name="T_TYPE_DOSSIER")
public class TypeDossier {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="ID_TYPE_DOSSIER",nullable=false, unique=true)
    private Long IdTypeDossier ;

    @Column(name="LIBELLE",nullable=false)
    private String Libelle ;
}
