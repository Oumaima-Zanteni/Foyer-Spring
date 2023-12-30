package com.example.foyerspring.DAO.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "foyer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Foyer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idFoyer;

    private String nomFoyer;

    @Column(name = "capaciteFoyer")
    private long capaciteFoyer;

    @JsonIgnoreProperties("foyer")
    @OneToMany(mappedBy = "foyer")
    @JsonIgnore
    List<Bloc> bloc=new ArrayList<>();

    @OneToOne(mappedBy = "foyer")
    private Universite universite;
}
