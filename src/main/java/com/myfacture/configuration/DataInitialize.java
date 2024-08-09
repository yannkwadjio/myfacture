package com.myfacture.configuration;

import com.myfacture.entity.Utilisateur;
import com.myfacture.enums.Role;
import com.myfacture.repository.UtilisateurRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Configuration
@RequiredArgsConstructor
public class DataInitialize {
    private final UtilisateurRepository utilisateurRepository;
    private final PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init() {
        Optional<Utilisateur> utilisateur = utilisateurRepository.findByEmail("myfacture@gmail.com");

        if (utilisateur.isEmpty()) {
            Utilisateur newUtilisateur = new Utilisateur();
            newUtilisateur.setRole(Set.of(Role.ADMIN));
            newUtilisateur.setMotDePasse(passwordEncoder.encode("myfacture@gmail.com"));
            newUtilisateur.setConnected(false);
            newUtilisateur.setEmail("myfacture@gmail.com");
            newUtilisateur.setCodeActivation(UUID.randomUUID().toString());
            newUtilisateur.setNomComplet("myfacture 1.0");
            newUtilisateur.setNumberConnexion(0);
            newUtilisateur.setNumeroTelephone(666666666L);
            newUtilisateur.setActivate(true);
            newUtilisateur.setConfirmationMdp(passwordEncoder.encode("myfacture@gmail.com"));
            newUtilisateur.setCodeReinitialisationMdp(UUID.randomUUID().toString());
            utilisateurRepository.save(newUtilisateur);
        }
    }
}
