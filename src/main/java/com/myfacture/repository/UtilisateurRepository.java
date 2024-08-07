package com.myfacture.repository;

import com.myfacture.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur,Integer> {
    Optional<Utilisateur> findByEmail(String email);
    Optional<Utilisateur> findByPhoneNumber(int phoneNumber);
    Optional<Utilisateur> findByFullName(String fullName);
}
