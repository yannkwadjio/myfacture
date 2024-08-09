package com.myfacture.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EntrepriseDto {
    private String nom;
    private String adresse;
    private List<String> email;
    private List<Integer> numeroTelephone;
    private String nui;
    private String rc;
    private int bp;
    private String slogan;


}
