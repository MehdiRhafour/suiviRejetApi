package com.suivirejet.suivirejetapi.controller;


import com.suivirejet.suivirejetapi.Repository.TypeMotifRejetDossierRepository;
import com.suivirejet.suivirejetapi.entity.TypeMotifRejetDossier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ParametrageController {

    @Autowired
    private TypeMotifRejetDossierRepository typeMotifRejetDossierRepository ;


    @GetMapping("parametrage/getMotifRejet")
    public List<TypeMotifRejetDossier> getTypeMotifRejetDossier(){
        return typeMotifRejetDossierRepository.findAll() ;
    }
}
