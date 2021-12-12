package com.suivirejet.suivirejetapi.controller;

import com.suivirejet.suivirejetapi.Repository.AgentRepository;
import com.suivirejet.suivirejetapi.Repository.DossierAMORepository;
import com.suivirejet.suivirejetapi.Repository.SuiviDossierAMORepository;
import com.suivirejet.suivirejetapi.entity.Agent;
import com.suivirejet.suivirejetapi.entity.DossierAMO;
import com.suivirejet.suivirejetapi.entity.SuiviDossierAMO;
import com.suivirejet.suivirejetapi.services.SuiviDossierAMOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class DossierAReexpedierController {

    @Autowired
    DossierAMORepository dossierAMORepository ;

    @Autowired
    AgentRepository agentRepository ;

    @Autowired
    SuiviDossierAMOService suiviDossierAMOService ;

    @Autowired
    SuiviDossierAMORepository suiviDossierAMORepository ;

    @GetMapping("dossiersAReexpedier")
    public List<DossierAMO> getDossierAMOAReexpedier()  {

        return dossierAMORepository.findByEtatTracabilite();
    }

    @PostMapping(value = "dossiersAReexpedier/saveDossierReexpedier")
    public List<DossierAMO> ReexpedierDossier(@RequestBody HashMap<String,String> postBody){

        String idDossierAMOString = postBody.get("idDossierAMO") ;
        String idActionString = postBody.get("idAction") ;
        String numeroRecommande = postBody.get("numeroRecommande") ;

        int idDossierAMO = Integer.parseInt(idDossierAMOString) ;
        int idAction = Integer.parseInt(idActionString) ;

        DossierAMO dossierAMO = dossierAMORepository.findByIdDossierAMO(idDossierAMO) ;
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Agent agent = agentRepository.findByMatricule(username) ;
        if(agent != null){
            suiviDossierAMOService.saveSuiviDossierAMO(dossierAMO, idAction, agent.getIdAgent(),numeroRecommande);
        }

        return dossierAMORepository.findByEtatTracabilite();
    }
}
