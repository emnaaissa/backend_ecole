package com.backend.backend.models;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Classe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_classe")
    private Long id_classe;

    @Column(name = "nom_classe")
    private String nom_classe;

    @Column(name = "niveau_classe")
    private String niveau_classe;

    @OneToMany(mappedBy = "classe")
    @JsonManagedReference
    private List<Eleve> eleves;

    // Getters et Setters

    public Long getId_classe() {
        return id_classe;
    }

    public void setId_classe(Long id_classe) {
        this.id_classe = id_classe;
    }

    public String getNom_classe() {
        return nom_classe;
    }

    public void setNom_classe(String nom_classe) {
        this.nom_classe = nom_classe;
    }

    public String getNiveau_classe() {
        return niveau_classe;
    }

    public void setNiveau_classe(String niveau_classe) {
        this.niveau_classe = niveau_classe;
    }

    public List<Eleve> getEleves() {
        return eleves;
    }

    public void setEleves(List<Eleve> eleves) {
        this.eleves = eleves;
    }
}