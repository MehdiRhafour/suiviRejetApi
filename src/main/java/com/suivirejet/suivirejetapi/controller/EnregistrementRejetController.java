package com.suivirejet.suivirejetapi.controller;


import com.suivirejet.suivirejetapi.Repository.DossierAMORepository;
import com.suivirejet.suivirejetapi.entity.*;
import com.suivirejet.suivirejetapi.services.EnregistrementRejetService;
import com.suivirejet.suivirejetapi.services.MailService;
import com.suivirejet.suivirejetapi.services.SharedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class EnregistrementRejetController {

    @Autowired
    private EnregistrementRejetService enregistrementRejetService ;

    @Autowired
    private MailService mailService ;

    @Autowired
    private DossierAMORepository dossierAMORepository ;

    @Autowired
    private SharedService sharedService;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss") ;


    @GetMapping(value = "tracabilite/{numDossier}")
    public TracabiliteDossier getDossierTracabiliteRejeteByNumeroDossier(@PathVariable String numDossier){
        return enregistrementRejetService.findTracabiliteDossierByNumero(numDossier) ;
    }


    @GetMapping(value = "dossierAMO/{numDossier}")
    public List<SuiviDossierAMO> getDossierAMOByNumeroDossier(@PathVariable String numDossier){
        return enregistrementRejetService.findListSuiviDossierAMOByNumDossier(numDossier) ;
    }

    @PostMapping("rejet/saveRejet")
    public DossierAMO enregistrerRejet(@RequestBody HashMap<String,String> postBody){

        String adresseAssure = postBody.get("adresseAssure") ;
        String numeroTel = postBody.get("numeroTele") ;
        int idMotifRejet = Integer.parseInt(postBody.get("idMotifRejet")) ;
        int idTracabiliteDossier = Integer.parseInt(postBody.get("idTracabiliteDossier")) ;
        return enregistrementRejetService.saveDossierRejet(adresseAssure,numeroTel,idMotifRejet,idTracabiliteDossier);

    }


}
