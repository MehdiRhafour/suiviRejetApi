package com.suivirejet.suivirejetapi.controller;


import com.suivirejet.suivirejetapi.entity.Agent;
import com.suivirejet.suivirejetapi.entity.DossierAMO;
import com.suivirejet.suivirejetapi.entity.SuiviDossierAMO;
import com.suivirejet.suivirejetapi.services.EnregistrementRejetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ConsultationDossierController {

    @Autowired
    private EnregistrementRejetService enregistrementRejetService ;

    @PostMapping(value = "dossier/consultationDossier")
    public List<SuiviDossierAMO> ReexpedierDossier(@RequestBody HashMap<String,String> postBody){

        String numDossierAMO = postBody.get("numDossierAMO") ;
        String numImmatriculation = postBody.get("numImm") ;

        return enregistrementRejetService.findListSuiviDossierAMOByNumDossierAndIMM(numDossierAMO,numImmatriculation) ;


    }
}
