package com.suivirejet.suivirejetapi.Repository;

import com.suivirejet.suivirejetapi.entity.EtatDossierTracabilite;
import com.suivirejet.suivirejetapi.entity.TracabiliteDossier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TracabiliteDossierRepository extends JpaRepository<TracabiliteDossier,Integer> {

    TracabiliteDossier findTracabiliteDossierByNumeroDossierAndEtatDossierTracabilite(String numeroDossier, EtatDossierTracabilite etatDossierTracabilite) ;

    TracabiliteDossier findTracabiliteDossierByNumeroDossier(String numeroDossier) ;

    TracabiliteDossier findTracabiliteDossierByIdTracabiliteDossier(int idDossierTracabilite) ;

}
