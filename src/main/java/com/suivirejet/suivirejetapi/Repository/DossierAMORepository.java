package com.suivirejet.suivirejetapi.Repository;

import com.suivirejet.suivirejetapi.entity.DossierAMO;
import com.suivirejet.suivirejetapi.entity.TracabiliteDossier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DossierAMORepository extends JpaRepository<DossierAMO,Integer> {

    //DossierAMO findDossierAMOByTracabiliteDossier(TracabiliteDossier tracabiliteDossier) ;
    DossierAMO findByTracabiliteDossier(TracabiliteDossier tracabiliteDossier) ;

    DossierAMO findByNumeroDossier(String numeroDossier) ;

    @Query(value = "SELECT * FROM  T_DOSSIER_AMO tda INNER JOIN T_TRACABILITE_DOSSIER ttd  WHERE tda.ID_TRACABILITE_DOSSIER = ttd.ID_TRACABILITE_DOSSIER  and ttd.ID_ETAT_DOSSIER_TRACABILITE  = 2 ", nativeQuery = true)
    List<DossierAMO> findByEtatTracabilite();

    DossierAMO findByIdDossierAMO(int idDossierAMO) ;

    DossierAMO findDossierAMOByNumeroDossierOrNumeroImmatriculation(String idDossierAMO , String numeroImmatriculation) ;
}

   // Authentication auth = SecurityContextHolder.getContext().getAuthentication().getName();