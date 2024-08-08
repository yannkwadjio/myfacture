package com.myfacture.configuration;

import com.myfacture.entity.Utilisateur;
import com.myfacture.repository.UtilisateurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DetailConnexionUser implements UserDetailsService {
    private final UtilisateurRepository utilisateurRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Utilisateur utilisateur = utilisateurRepository.findByEmail(username)
                .orElseThrow(()->new RuntimeException("Utilisateur absent dans la bd"));

        if(!utilisateur.isActivate()){
            throw new UsernameNotFoundException("Utilisateur inactif");
        }

        if(utilisateur.isConnected()){
            throw new UsernameNotFoundException("Utilisateur déjà connecté");
        }

        utilisateur.setNumberConnexion(utilisateur.getNumberConnexion()+1);
        utilisateur.setConnected(true);

        return new User(utilisateur.getUsername(),utilisateur.getPassword(),utilisateur.getRole().stream()
                .map(role -> new SimpleGrantedAuthority(role.name()))
                .collect(Collectors.toSet()));
    }
}
