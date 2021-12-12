package com.suivirejet.suivirejetapi.Repository;

import com.suivirejet.suivirejetapi.entity.NiveauSuivi;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NiveauSuiviRepository extends JpaRepository<NiveauSuivi,Integer> {

    NiveauSuivi findByIdNiveauSuivi(int idNiveauSuivi) ;
}
