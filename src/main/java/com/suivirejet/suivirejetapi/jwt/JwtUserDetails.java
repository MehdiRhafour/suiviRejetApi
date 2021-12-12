package com.suivirejet.suivirejetapi.jwt;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.suivirejet.suivirejetapi.entity.Affectation;
import com.suivirejet.suivirejetapi.entity.Role;
import com.suivirejet.suivirejetapi.entity.TypeAffectation;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class JwtUserDetails implements UserDetails {

    private static final long serialVersionUID = 5155720064139820502L;

    private final Long id;
    private final String username;
    private final String password;
    private final String nom ;
    private final String prenom ;
    private final Affectation affectation ;
    private final TypeAffectation typeAffectation ;
    private final Collection<? extends GrantedAuthority> authorities;

    public JwtUserDetails(Long id, String username, String password, String role, String nom, String prenom , Affectation affectation, TypeAffectation typeAffectation) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.nom = nom ;
        this.prenom = prenom ;
        this.affectation = affectation ;
        this.typeAffectation = typeAffectation ;


        List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(role));

        this.authorities = authorities;
    }

    @JsonIgnore
    public Long getId() {
        return id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}

