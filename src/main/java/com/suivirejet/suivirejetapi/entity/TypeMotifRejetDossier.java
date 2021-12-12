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
@Table(name="T_TYPE_MOTIF_REJET_DOSSIER")
public class TypeMotifRejetDossier {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="ID_TYPE_MOTIF_REJET_DOSSIER",nullable=false, unique=true)
    private int idTypeRejetDossier ;

    @Column(name="LIBELLE" ,nullable = false)
    private String Libelle  ;
}
