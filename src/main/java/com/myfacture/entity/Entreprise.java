package com.myfacture.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "entreprise")
public class Entreprise {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nom;
    private String adresse;
    private List<String> email;
    private List<Integer> numeroTelephone;
    private String nui;
    private String rc;
    private int bp;
    private String slogan;
}
