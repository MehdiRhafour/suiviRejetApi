package com.suivirejet.suivirejetapi.cron;

import com.suivirejet.suivirejetapi.Repository.AgentRepository;
import com.suivirejet.suivirejetapi.Repository.DossierAMORepository;
import com.suivirejet.suivirejetapi.Repository.EtatDossierTracabiliteRepository;
import com.suivirejet.suivirejetapi.Repository.TracabiliteDossierRepository;
import com.suivirejet.suivirejetapi.entity.*;
import com.suivirejet.suivirejetapi.services.MailService;
import com.suivirejet.suivirejetapi.services.SharedService;
import com.suivirejet.suivirejetapi.services.SuiviDossierAMOService;
import com.suivirejet.suivirejetapi.twilio.SMSRequest;
import com.suivirejet.suivirejetapi.twilio.TwilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
@EnableScheduling
@Service
public class CronEnvoieNotification {

    private final TwilioService twilioService ;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss") ;

    @Autowired
    private DossierAMORepository dossierAMORepository ;

    @Autowired
    private SharedService sharedService ;

    @Autowired
    private MailService mailService ;

    @Autowired
    private SuiviDossierAMOService suiviDossierAMOService ;

    @Autowired
    private EtatDossierTracabiliteRepository etatDossierTracabiliteRepository ;

    @Autowired
    private TracabiliteDossierRepository tracabiliteDossierRepository ;

    @Autowired
    public CronEnvoieNotification(TwilioService twilioService) {
        this.twilioService = twilioService;
    }
    //         0 0 5 * * *
    @Scheduled(cron = "0 * * * * *")
    public void EnvoieNotitication(){

            List<DossierAMO> dossierAMOS = dossierAMORepository.findAll() ;
            if(dossierAMOS.size() != 0){

                for (int i=0; i<=dossierAMOS.size()-1;i++) {
                    DossierAMO dossierAMO = dossierAMOS.get(i) ;
                    NiveauSuivi niveauSuivi = dossierAMO.getDernierNiveauSuivi() ;
                    String phoneNumber = dossierAMO.getNumeroTelAssure() ;
                    String emailAssure = dossierAMO.getEmailAssure() ;

                    Date Now = new Date() ;
                    Timestamp dateEnregistrementAMOTS = new Timestamp(dossierAMO.getDateEnregistrementAMO().getTime()) ;
                    Date dateEnregistrementAMO = new Date(dateEnregistrementAMOTS.getTime()) ;


                    if(niveauSuivi.getIdNiveauSuivi() == NiveauSuivi.SAISIE_REJET && sharedService.dateDiff(dateEnregistrementAMO, Now, SharedService.DATE_IN_DAYS) >= 1
                    ){
                        String message = sharedService.getNotificationRejetSMS(dossierAMO.getNumeroDossier(),dossierAMO.getAgence().getLibelle()) ;

                        SMSRequest smsRequest = new SMSRequest(phoneNumber,message) ;
                        System.out.println(smsRequest);
                        twilioService.sendSMS(smsRequest);

                        suiviDossierAMOService.saveSuiviDossierAMO(dossierAMO, NiveauSuivi.SMS_NOTIF_REJET, Agent.AGENT_AUTOMATE,"");

                    }else if(niveauSuivi.getIdNiveauSuivi() == NiveauSuivi.SMS_NOTIF_REJET && sharedService.dateDiff(dateEnregistrementAMO, Now, SharedService.DATE_IN_DAYS) >= 3){
                        String message = sharedService.getBodyEmailNotificationRejet(dossierAMO) ;
                        mailService.sendMail(dossierAMO.getEmailAssure(),"Rejet du dossier AMO",message) ;

                        suiviDossierAMOService.saveSuiviDossierAMO(dossierAMO, NiveauSuivi.EMAIL_NOTIF_REJET, Agent.AGENT_AUTOMATE,"");

                    }else if(niveauSuivi.getIdNiveauSuivi() == NiveauSuivi.EMAIL_NOTIF_REJET && sharedService.dateDiff(dateEnregistrementAMO,Now, SharedService.DATE_IN_DAYS) >= 5){

                        String message = sharedService.getNotificationRelanceRejetParSMS(dossierAMO.getNumeroDossier(), dossierAMO.getAgence().getLibelle()) ;

                        SMSRequest smsRequest = new SMSRequest(phoneNumber,message) ;
                        twilioService.sendSMS(smsRequest);

                        suiviDossierAMOService.saveSuiviDossierAMO(dossierAMO, NiveauSuivi.SMS_RELANCE_REJET, Agent.AGENT_AUTOMATE,"");

                    }else if(niveauSuivi.getIdNiveauSuivi() == NiveauSuivi.SMS_RELANCE_REJET && sharedService.dateDiff(dateEnregistrementAMO,Now, SharedService.DATE_IN_DAYS) >= 10 ){

                        mailService.sendMailEmailWithAttachement("ammr.nouhas@gmail.com",emailAssure,"Convocation AMO"," ","/Macintosh HD/Utilisateurs/Sbe3-Ammr 1/Bureau/Convocation Agence pour Complément d’informations_Indice de révision 01_ 11-11-2020.pdf") ;

                        suiviDossierAMOService.saveSuiviDossierAMO(dossierAMO, NiveauSuivi.ENVOIE_CONVOCATION, Agent.AGENT_AUTOMATE,"");

                    }else if(niveauSuivi.getIdNiveauSuivi() == NiveauSuivi.ENVOIE_CONVOCATION && sharedService.dateDiff(dateEnregistrementAMO,Now, SharedService.DATE_IN_DAYS) >= 30 ){
                        // appel vocale n'est pas implémentée
                        TracabiliteDossier tracabiliteDossier = dossierAMO.getTracabiliteDossier() ;
                        if(tracabiliteDossier != null){
                            EtatDossierTracabilite etatDossierTracabilite = etatDossierTracabiliteRepository.findByIdEtatDossierTracabilite(EtatDossierTracabilite.ETAT_A_REEXPEDIER_AGENCE_ASSURE) ;
                            tracabiliteDossier.setEtatDossierTracabilite(etatDossierTracabilite);
                            tracabiliteDossierRepository.save(tracabiliteDossier) ;

                        }
                    }
                }
            }

       System.out.println("current time = " + dateFormat.format(new Date()));
    }
}
