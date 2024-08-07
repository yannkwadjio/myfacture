package com.myfacture.services.services;

import com.myfacture.repository.UtilisateurRepository;
import com.myfacture.services.interfaces.UtilisateurInterfaces;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UtilisateurServices implements UtilisateurInterfaces {
    private final UtilisateurRepository utilisateurRepository;
}
