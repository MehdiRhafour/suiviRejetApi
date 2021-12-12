package com.suivirejet.suivirejetapi.Repository;

import com.suivirejet.suivirejetapi.entity.DossierAMO;
import com.suivirejet.suivirejetapi.entity.SuiviDossierAMO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SuiviDossierAMORepository extends JpaRepository<SuiviDossierAMO, Integer> {

    List<SuiviDossierAMO> findSuiviDossierAMOSByDossierAMO(DossierAMO dossierAMO) ;

}
