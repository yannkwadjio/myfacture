package com.myfacture.configuration;

import com.myfacture.entity.Utilisateur;
import com.myfacture.enums.Role;
import com.myfacture.repository.UtilisateurRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Configuration
@RequiredArgsConstructor
public class DataInitialize {
    private final UtilisateurRepository utilisateurRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @PostConstruct
    public void init() {
        Optional<Utilisateur> utilisateur = utilisateurRepository.findByEmail("myfacture@gmail.com");

        if (utilisateur.isEmpty()) {
            Utilisateur newUtilisateur = new Utilisateur();
            newUtilisateur.setRole(Set.of(Role.ADMIN));
            newUtilisateur.setPassword(passwordEncoder.encode("myfacture@gmail.com"));
            newUtilisateur.setConnected(false);
            newUtilisateur.setEmail("myfacture@gmail.com");
            newUtilisateur.setActivationCode(UUID.randomUUID().toString());
            newUtilisateur.setFullName("myfacture 1.0");
            newUtilisateur.setNumberConnexion(0);
            newUtilisateur.setPhoneNumber(666666666L);
            newUtilisateur.setActivate(true);
            newUtilisateur.setPasswordConfirmation(passwordEncoder.encode("myfacture@gmail.com"));
            newUtilisateur.setPasswordResetCode(UUID.randomUUID().toString());
            utilisateurRepository.save(newUtilisateur);
        }
    }
}
