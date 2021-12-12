package com.suivirejet.suivirejetapi.controller;

import com.suivirejet.suivirejetapi.Repository.AgentRepository;
import com.suivirejet.suivirejetapi.entity.Agent;
import com.suivirejet.suivirejetapi.entity.TracabiliteDossier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AgentController {

    @Autowired
    private AgentRepository agentRepository ;

    @GetMapping("agent/{matricule}")
    public Agent getAgentConnected(@PathVariable String matricule){
          return agentRepository.findByMatricule(matricule) ;
    }

}
