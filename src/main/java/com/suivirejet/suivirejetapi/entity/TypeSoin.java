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
@Table(name="T_TYPE_SOIN")
public class TypeSoin {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="ID_TYPE_SOIN",nullable=false, unique=true)
    private Long IdTypeSoin ;

    @Column(name="LIBELLE",nullable=false)
    private String Libelle ;

}
