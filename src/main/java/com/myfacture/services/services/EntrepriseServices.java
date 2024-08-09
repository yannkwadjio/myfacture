package com.myfacture.services.services;

import com.myfacture.dto.EntrepriseDto;
import com.myfacture.entity.Entreprise;
import com.myfacture.repository.EntrepriseRepository;
import com.myfacture.services.interfaces.EntrepriseInterfaces;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EntrepriseServices implements EntrepriseInterfaces {
    private final EntrepriseRepository entrepriseRepository;

    @Override
    public Map<String, String> createEntreprise(EntrepriseDto entrepriseDto) {
        Map<String, String> response = new HashMap<>();
        String regex = "^[A-Za-z0-9._%+-]+@XXXXX\\.XXX$";;
        Optional<Entreprise> entreprise = entrepriseRepository.findByNom(entrepriseDto.getNom());
        Entreprise nouvelleEntreprise=new Entreprise();
        if (entreprise.isEmpty()) {
            if (!entrepriseDto.getNom().isEmpty()) {
                if (!entrepriseDto.getEmail().isEmpty()) {
                    if (!entrepriseDto.getNumeroTelephone().isEmpty()) {
                        nouvelleEntreprise.setRc(entrepriseDto.getRc().toUpperCase());
                       for(String email:entrepriseDto.getEmail()){
                           if(email.matches(regex)){
                               nouvelleEntreprise.getEmail().add(email);
                           }else {
                               response.put("message", email+" n'est pas une adresse Email");
                               throw new RuntimeException("Adresse Email incorrecte");
                           }
                       }
                        for(int telephone:entrepriseDto.getNumeroTelephone()){
                              nouvelleEntreprise.getNumeroTelephone().add(telephone);
                        }
                        nouvelleEntreprise.setBp(entrepriseDto.getBp());
                        nouvelleEntreprise.setAdresse(entrepriseDto.getAdresse());
                        nouvelleEntreprise.setNui(entrepriseDto.getNui().toUpperCase());
                        nouvelleEntreprise.setNom(entrepriseDto.getNom());
                        nouvelleEntreprise.setSlogan(entrepriseDto.getSlogan());
                        entrepriseRepository.save(nouvelleEntreprise);
                        response.put("message","L'entreprise "+nouvelleEntreprise.getNom()+" a été enregistrée avec succès");

                    } else {
                        response.put("message", "No de téléphone de l'entreprise non renseignée");
                    }
                } else {
                    response.put("message", "Adresse E-mail de l'entreprise non renseignée");
                }
            } else {
                response.put("message", "Nom de l'entreprise non renseignée");
            }

        } else {
            response.put("message", "Cette entreprise existe déjà");
        }
        return response;
    }

    @Override
    public List<Entreprise> getAllEntreprise() {
        return entrepriseRepository.findAll();
    }

    @Override
    public EntrepriseDto getEntrepriseById(int id) {
        Entreprise entreprise=entrepriseRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Entreprise absente dans la bd"));
        return EntrepriseDto.builder()
                .nui(entreprise.getNui())
                .rc(entreprise.getRc())
                .bp(entreprise.getBp())
                .nom(entreprise.getNom())
                .adresse(entreprise.getAdresse())
                .numeroTelephone(entreprise.getNumeroTelephone())
                .slogan(entreprise.getSlogan())
                .email(entreprise.getEmail())
                .build();

    }
}
