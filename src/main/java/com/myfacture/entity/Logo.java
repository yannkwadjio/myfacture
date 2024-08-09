package com.myfacture.entity;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "logo")
public class Logo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nomEntreprise;
    private String nomfichier;
    private String typeFichier;
}
