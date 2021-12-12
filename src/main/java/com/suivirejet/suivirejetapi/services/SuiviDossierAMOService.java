package com.suivirejet.suivirejetapi.services;

import com.suivirejet.suivirejetapi.Repository.*;
import com.suivirejet.suivirejetapi.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SuiviDossierAMOService {

    @Autowired
    private NiveauSuiviRepository niveauSuiviRepository ;

    @Autowired
    private AgentRepository agentRepository ;

    @Autowired
    private SuiviDossierAMORepository suiviDossierAMORepository ;

    @Autowired
    private DossierAMORepository dossierAMORepository ;

    @Autowired
    private EtatDossierTracabiliteRepository etatDossierTracabiliteRepository ;

    @Autowired
    private TracabiliteDossierRepository tracabiliteDossierRepository ;

    public void saveSuiviDossierAMO(DossierAMO dossierAMO, int idSuiviDossierAMO, int idAgentAction, String numeroRecommande){

        SuiviDossierAMO suiviDossierAMO = new SuiviDossierAMO() ;
        suiviDossierAMO.setDossierAMO(dossierAMO);
        suiviDossierAMO.setDateEnregistrementDossierAMO(dossierAMO.getDateEnregistrementAMO());
        suiviDossierAMO.setDateActionNiveauSuivi(new Date());

        Agent agentAction = agentRepository.findAgentByIdAgent(idAgentAction) ;
        if(agentAction != null){
            suiviDossierAMO.setAgentAction(agentAction);
        }

        NiveauSuivi niveauSuivi = niveauSuiviRepository.findByIdNiveauSuivi(idSuiviDossierAMO) ;
        if(niveauSuivi != null){
            suiviDossierAMO.setNiveauSuivi(niveauSuivi);
        }

        dossierAMO.setDernierNiveauSuivi(niveauSuivi);
        dossierAMO.setDateActionDernierNiveau(suiviDossierAMO.getDateActionNiveauSuivi());

        if(idSuiviDossierAMO == NiveauSuivi.ENVOIE_RECOMMANDE){
            suiviDossierAMO.setNumeroRecommande(numeroRecommande);
            TracabiliteDossier tracabiliteDossier = dossierAMO.getTracabiliteDossier() ;
            EtatDossierTracabilite etatDossierTracabilite = etatDossierTracabiliteRepository.findByIdEtatDossierTracabilite(EtatDossierTracabilite.ETAT_REEXPEDIER_AGENCE_ASSURE) ;
            tracabiliteDossier.setEtatDossierTracabilite(etatDossierTracabilite);
            tracabiliteDossierRepository.save(tracabiliteDossier) ;
        }
        suiviDossierAMORepository.save(suiviDossierAMO) ;
        dossierAMORepository.save(dossierAMO) ;


    }
}
