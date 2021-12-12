package com.suivirejet.suivirejetapi.Repository;

import com.suivirejet.suivirejetapi.entity.Affectation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AffectationRepository extends JpaRepository<Affectation,Integer> {
    Affectation findByIdAffectation(int idAffectation) ;
}
