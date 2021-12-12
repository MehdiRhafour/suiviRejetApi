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
@Table(name="T_DIRECTION_GENERALE")
public class DirectionGenerale {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="ID_DIRECTION_GENERALE",nullable=false, unique=true)
    private int idDirectionGenerale ;

    @Column(name="LIBELLE",nullable = false)
    private String libelle ;

}
