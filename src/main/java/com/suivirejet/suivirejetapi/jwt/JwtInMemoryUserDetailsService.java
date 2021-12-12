package com.suivirejet.suivirejetapi.jwt;

import com.suivirejet.suivirejetapi.Repository.AgentRepository;
import com.suivirejet.suivirejetapi.entity.Agent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JwtInMemoryUserDetailsService implements UserDetailsService {

    static List<JwtUserDetails> inMemoryUserList = new ArrayList<>();


    @Autowired
    public AgentRepository agentRepository ;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Agent agent = agentRepository.findByMatricule(username) ;

        if(agent instanceof Agent){
            JwtUserDetails agentCast = new JwtUserDetails(1L,
                    agent.getMatricule(),
                    agent.getPassword(),
                    agent.getRole().getLibelle(),
                    agent.getNom(),agent.getPrenom(),
                    agent.getAffectation(),
                    agent.getTypeAffectation()) ;
            return agentCast ;
        }else{
            throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
        }
    }

}