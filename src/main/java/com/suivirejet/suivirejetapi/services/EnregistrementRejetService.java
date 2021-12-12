package com.suivirejet.suivirejetapi.services;

import com.suivirejet.suivirejetapi.Repository.*;
import com.suivirejet.suivirejetapi.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import static java.lang.Integer.parseInt;

@Service
public class EnregistrementRejetService {

    @Autowired
    private TracabiliteDossierRepository tracabiliteDossierRepository ;

    @Autowired
    private EtatDossierTracabiliteRepository etatDossierTracabiliteRepository ;

    @Autowired
    private DossierAMORepository dossierAMORepository ;

    @Autowired
    private AgentRepository agentRepository ;

    @Autowired
    private TypeMotifRejetDossierRepository typeMotifRejetDossierRepository ;

    @Autowired
    private NiveauSuiviRepository niveauSuiviRepository ;

    @Autowired
    private SuiviDossierAMORepository suiviDossierAMORepository ;

    public TracabiliteDossier findTracabiliteDossierByNumero(String numDossier){

        return  tracabiliteDossierRepository.findTracabiliteDossierByNumeroDossier(numDossier) ;
    }

    public DossierAMO findDossierAMOByNumero(String numDossier){
        return dossierAMORepository.findByNumeroDossier(numDossier) ;
    }

    public List<SuiviDossierAMO> findListSuiviDossierAMOByNumDossier(String numDossier){
        DossierAMO dossierAMO = dossierAMORepository.findByNumeroDossier(numDossier) ;
        return suiviDossierAMORepository.findSuiviDossierAMOSByDossierAMO(dossierAMO) ;
    }

    public DossierAMO saveDossierRejet(String adresseAssure,String numeroTele,int idTypeMotifRejet,int idTracabiliteDossier){

//        try {


            TracabiliteDossier tracabiliteDossier = tracabiliteDossierRepository.findTracabiliteDossierByIdTracabiliteDossier(idTracabiliteDossier) ;
            DossierAMO dossierAMODB = dossierAMORepository.findByTracabiliteDossier(tracabiliteDossier) ;

            String username = SecurityContextHolder.getContext().getAuthentication().getName();
            Agent agent = agentRepository.findByMatricule(username) ;

            DossierAMO dossierAMO = new DossierAMO() ;
            if(dossierAMODB == null ){

                dossierAMO.setTracabiliteDossier(tracabiliteDossier);
                dossierAMO.setNumeroDossier(tracabiliteDossier.getNumeroDossier());
                dossierAMO.setNumeroImmatriculation(tracabiliteDossier.getNumeroImmatriculation());
                dossierAMO.setAgence(tracabiliteDossier.getAgence());
                dossierAMO.setDirectionGenerale(tracabiliteDossier.getDirectionGenerale());
                dossierAMO.setAssure(tracabiliteDossier.getAssure());
                dossierAMO.setNomAssure(tracabiliteDossier.getAssure().getNom());
                dossierAMO.setPrenomAssure(tracabiliteDossier.getAssure().getPrenom());
                dossierAMO.setEmailAssure(tracabiliteDossier.getEmailAssure());
                dossierAMO.setCodePostal(tracabiliteDossier.getCodePostal());
                dossierAMO.setVille(tracabiliteDossier.getVille());

                dossierAMO.setDateDepot(tracabiliteDossier.getDateDepot());
                dossierAMO.setDateEnregistrementAMO(new Date());

                dossierAMO.setNomBeneficiaire(tracabiliteDossier.getNomBeneficiaire());
                dossierAMO.setPrenomBeneficiaire(tracabiliteDossier.getPrenomBeneficiaire());
                dossierAMO.setTypeDossier(tracabiliteDossier.getTypeDossier());
                dossierAMO.setTypeSoin(tracabiliteDossier.getTypeSoin());
                dossierAMO.setMontant(tracabiliteDossier.getMontant());

                dossierAMO.setDateCreation(new Date());


                dossierAMO.setAgentCreation(agent);

            }else{
                dossierAMO = dossierAMODB ;
                dossierAMO.setDateModification(new Date());
                dossierAMO.setAgentModification(agent);

            }

            if(adresseAssure != null){
                dossierAMO.setAdresseAssure(adresseAssure);
            }else{
                dossierAMO.setAdresseAssure(tracabiliteDossier.getAdresseAssure());
            }

            dossierAMO.setNumeroTelAssure(numeroTele);

            if(idTypeMotifRejet != 0){
                TypeMotifRejetDossier typeMotifRejetDossier = typeMotifRejetDossierRepository.findTypeMotifRejetDossierByIdTypeRejetDossier(idTracabiliteDossier) ;
                dossierAMO.setTypeMotifRejetDossier(typeMotifRejetDossier);
            }

            if(dossierAMODB == null){
                dossierAMORepository.save(dossierAMO) ;

                NiveauSuivi niveauSuivi = niveauSuiviRepository.findByIdNiveauSuivi(NiveauSuivi.SAISIE_REJET) ;
                SuiviDossierAMO suiviDossierAMO = this.enregistrerSuiviDossierAMO(dossierAMO,niveauSuivi) ;
                dossierAMO.setDernierNiveauSuivi(niveauSuivi);
                dossierAMO.setDateActionDernierNiveau(suiviDossierAMO.getDateActionNiveauSuivi());
            }
            dossierAMORepository.save(dossierAMO) ;
            dossierAMORepository.flush();

            return dossierAMO ;

//        }catch (Exception e){
//            return false ;
//        }
    }

    public SuiviDossierAMO enregistrerSuiviDossierAMO(DossierAMO dossierAMO, NiveauSuivi niveauSuivi){

        SuiviDossierAMO suiviDossierAMO = new SuiviDossierAMO() ;
        suiviDossierAMO.setDossierAMO(dossierAMO);
        suiviDossierAMO.setDateEnregistrementDossierAMO(dossierAMO.getDateEnregistrementAMO());
        suiviDossierAMO.setNiveauSuivi(niveauSuivi);

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Agent agent = agentRepository.findByMatricule(username) ;
        suiviDossierAMO.setAgentAction(agent);
        suiviDossierAMO.setDateActionNiveauSuivi(new Date());

        suiviDossierAMORepository.save(suiviDossierAMO) ;
        suiviDossierAMORepository.flush();

        return suiviDossierAMO ;
    }

    public List<SuiviDossierAMO> findListSuiviDossierAMOByNumDossierAndIMM(String numDossier, String numeroIMM){
        DossierAMO dossierAMO = dossierAMORepository.findDossierAMOByNumeroDossierOrNumeroImmatriculation(numDossier,numeroIMM) ;
        return suiviDossierAMORepository.findSuiviDossierAMOSByDossierAMO(dossierAMO) ;
    }
}
