package com.suivirejet.suivirejetapi.Repository;

import com.suivirejet.suivirejetapi.entity.TypeMotifRejetDossier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeMotifRejetDossierRepository extends JpaRepository<TypeMotifRejetDossier,Integer> {
    TypeMotifRejetDossier findTypeMotifRejetDossierByIdTypeRejetDossier(int idTypeMotifRejetDossier) ;

}
