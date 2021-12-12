package com.suivirejet.suivirejetapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.lang.reflect.Type;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Table(name="T_AGENT")
public class Agent {

    public static final int AGENT_AUTOMATE = 2 ;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="ID_AGENT",nullable=false, unique=true)
    private int idAgent ;

    @Column(name="MATRICULE",nullable = false,unique = true)
    private String matricule  ;

    @Column(name="PASSWORD",nullable = false)
    private String password  ;

    @Column(name="NOM")
    private String nom ;

    @Column(name="PRENOM")
    private String prenom ;

    @Column(name="EMAIL")
    private String email ;

    @ManyToOne(targetEntity = Affectation.class)
    @JoinColumn(name="ID_AFFECTATION",nullable = false)
    private Affectation affectation ;

    @ManyToOne(targetEntity = TypeAffectation.class)
    @JoinColumn(name = "ID_TYPE_AFFECTATION", referencedColumnName = "ID_TYPE_AFFECTATION")
    private TypeAffectation typeAffectation ;

    @ManyToOne(targetEntity = Role.class)
    @JoinColumn(name="ID_ROLE",referencedColumnName = "ID_ROLE")
    private Role role ;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdAgent() {
        return idAgent;
    }

    public void setIdAgent(int idAgent) {
        this.idAgent = idAgent;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Affectation getAffectation() {
        return affectation;
    }

    public void setAffectation(Affectation affectation) {
        this.affectation = affectation;
    }

    public TypeAffectation getTypeAffectation() {
        return typeAffectation;
    }

    public void setTypeAffectation(TypeAffectation typeAffectation) {
        this.typeAffectation = typeAffectation;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
