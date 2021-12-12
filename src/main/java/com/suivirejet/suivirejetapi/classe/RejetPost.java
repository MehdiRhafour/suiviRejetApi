package com.suivirejet.suivirejetapi.classe;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class RejetPost {

    private String idMotifRejet ;
    private String numeroTele ;
    private String adresseAssure ;

    public String getIdMotifRejet() {
        return idMotifRejet;
    }

    public void setIdMotifRejet(String idMotifRejet) {
        this.idMotifRejet = idMotifRejet;
    }

    public String getNumeroTele() {
        return numeroTele;
    }

    public void setNumeroTele(String numeroTele) {
        this.numeroTele = numeroTele;
    }

    public String getAdresseAssure() {
        return adresseAssure;
    }

    public void setAdresseAssure(String adresseAssure) {
        this.adresseAssure = adresseAssure;
    }
}
