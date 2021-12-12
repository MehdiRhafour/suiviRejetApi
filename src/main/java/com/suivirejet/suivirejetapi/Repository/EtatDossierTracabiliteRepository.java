package com.suivirejet.suivirejetapi.Repository;

import com.suivirejet.suivirejetapi.entity.EtatDossierTracabilite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtatDossierTracabiliteRepository extends JpaRepository<EtatDossierTracabilite,Integer> {

    EtatDossierTracabilite findByIdEtatDossierTracabilite(int idEtatDossierTracabilite) ;
}
