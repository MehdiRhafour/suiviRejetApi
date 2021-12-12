package com.suivirejet.suivirejetapi.services;

import com.suivirejet.suivirejetapi.entity.DossierAMO;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;



@Service
public class SharedService {

    public static int DATE_IN_DAYS = 1 ;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss") ;

    public long dateDiff(Date dateStart, Date dateFin, int typeDate){

        long difference_In_Time = Math.abs(dateFin.getTime() - dateStart.getTime()) ;

        long difference = -1 ;
        if(typeDate == 1){
             difference
                    = (difference_In_Time
                    / (1000 * 60 * 60 * 24))
                    % 365;
        }

        return difference ;
    }

    public String getNotificationRejetSMS(String numDossier, String libelleAgenceRecuperation){
        String message = "\n\n\nVotre dossier AMO n° "+ numDossier +" est rejeté. Merci de se présenter, sans délai, à l’agence CNSS "  +
                libelleAgenceRecuperation+" afin de le récupérer pour le compléter.\n" ;
        return message ;
    }

    public String getBodyEmailNotificationRejet(DossierAMO dossierAMO){
        SimpleDateFormat myFormat = new SimpleDateFormat("dd-MM-yyyy");
        String message = "Madame Monsieur, "+dossierAMO.getNomAssure()+" "+dossierAMO.getPrenomAssure()+"\n" +
                "CNSS : "+dossierAMO.getNumeroImmatriculation()+"\n\n" +
                "Nous vous informons que votre dossier AMO n° "+ dossierAMO.getNumeroDossier()+" Concernant le bénéficiaire des soins " + dossierAMO.getTypeSoin().getLibelle() +" "+
                "déposé à l'agence CNSS " +dossierAMO.getAgence().getLibelle()+" en date du "+ myFormat.format(new Date(new Timestamp(dossierAMO.getDateDepot().getTime()).getTime()))+" est rejeté.\n\n"+
                "Veuillez vous présenter, sans délai, à l’agence de dépôt afin de le récupérer pour le compléter.\n"+
                "Veuillez accepter, Madame Monsieur, l’expression de nos salutations distinguées." ;
        return message ;
    }

    public String getNotificationRelanceRejetParSMS(String numDossier, String libelleAgenceRecuperation){
        String message = "\n\n\nRelance : \n"+
                "Votre dossier AMO n° "+ numDossier +" est rejeté. Merci de se présenter, sans délai, à l’agence CNSS "  +
                libelleAgenceRecuperation+" afin de le récupérer pour le compléter.\n" ;

        return message ;
    }
}
