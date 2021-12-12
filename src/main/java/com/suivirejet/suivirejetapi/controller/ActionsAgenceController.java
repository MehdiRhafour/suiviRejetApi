package com.suivirejet.suivirejetapi.controller;

import com.suivirejet.suivirejetapi.Repository.AgentRepository;
import com.suivirejet.suivirejetapi.Repository.DossierAMORepository;
import com.suivirejet.suivirejetapi.Repository.SuiviDossierAMORepository;
import com.suivirejet.suivirejetapi.entity.Agent;
import com.suivirejet.suivirejetapi.entity.DossierAMO;
import com.suivirejet.suivirejetapi.entity.NiveauSuivi;
import com.suivirejet.suivirejetapi.entity.SuiviDossierAMO;
import com.suivirejet.suivirejetapi.services.SuiviDossierAMOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ActionsAgenceController {

    @Autowired
    private SuiviDossierAMOService suiviDossierAMOService ;

    @Autowired
    private DossierAMORepository dossierAMORepository ;

    @Autowired
    private AgentRepository agentRepository ;

    @Autowired
    private SuiviDossierAMORepository suiviDossierAMORepository ;

    @GetMapping(value = "actionAgence/saveAction/{idDossierAMOString}/{idActionString}")
    public List<SuiviDossierAMO> SaveActionSuiviDossier(@PathVariable String idDossierAMOString, @PathVariable String idActionString){

        int idDossierAMO = Integer.parseInt(idDossierAMOString) ;
        int idAction = Integer.parseInt(idActionString) ;
        DossierAMO dossierAMO = dossierAMORepository.findByIdDossierAMO(idDossierAMO) ;
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Agent agent = agentRepository.findByMatricule(username) ;
        if(agent != null){
            suiviDossierAMOService.saveSuiviDossierAMO(dossierAMO, idAction, agent.getIdAgent(),"");
        }

        return suiviDossierAMORepository.findSuiviDossierAMOSByDossierAMO(dossierAMO) ;
    }

}
