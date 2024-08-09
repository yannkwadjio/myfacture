package com.myfacture.services.interfaces;

import com.myfacture.dto.EntrepriseDto;
import com.myfacture.entity.Entreprise;

import java.util.List;
import java.util.Map;

public interface EntrepriseInterfaces{
    Map<String, String> createEntreprise(EntrepriseDto entrepriseDto);

    List<Entreprise> getAllEntreprise();

    EntrepriseDto getEntrepriseById(int id);
}
