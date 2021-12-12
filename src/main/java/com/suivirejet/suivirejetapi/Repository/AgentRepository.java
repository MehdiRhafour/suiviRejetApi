package com.suivirejet.suivirejetapi.Repository;

import com.suivirejet.suivirejetapi.entity.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AgentRepository extends JpaRepository<Agent,Integer> {

    Agent findByMatricule(String matricule);

    Agent findAgentByIdAgent(int idAgent) ;
}
