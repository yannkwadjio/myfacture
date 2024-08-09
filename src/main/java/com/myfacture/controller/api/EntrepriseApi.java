package com.myfacture.controller.api;

import com.myfacture.dto.EntrepriseDto;
import com.myfacture.entity.Entreprise;
import com.myfacture.services.interfaces.EntrepriseInterfaces;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/enterprise/")
@RequiredArgsConstructor
public class EntrepriseApi {
    private final EntrepriseInterfaces entrepriseInterfaces;

    @PostMapping("create")
    public Map<String, String> createEntreprise(@RequestBody EntrepriseDto entrepriseDto) {
        return entrepriseInterfaces.createEntreprise(entrepriseDto);

    }

    @GetMapping("get-all")
    public List<Entreprise> getAllEntreprise(){
        return entrepriseInterfaces.getAllEntreprise();
    }

    @GetMapping("get-by-id/{id}")
    public EntrepriseDto getEntrepriseById(@PathVariable("id") int id){
        return entrepriseInterfaces.getEntrepriseById(id);
    }

    @GetMapping("delete-by-id/{id}")
    public EntrepriseDto deleteEntrepriseById(@PathVariable("id") int id){
        return entrepriseInterfaces.getEntrepriseById(id);
    }

}
