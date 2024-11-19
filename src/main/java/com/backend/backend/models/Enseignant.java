package com.backend.backend.models;

import jakarta.persistence.*;

@Entity
public class Enseignant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_enseignant")
    private Long id_enseignant;

    @Column(name = "nom_enseignant")
    private String nom_enseignant;

    @Column(name = "prenom_enseignant")
    private String prenom_enseignant;

    @Column(name = "matiere")
    private String matiere;

    @Lob // Indique que c'est un gros objet
    @Column(name = "emploi_file", nullable = true) // nullable = true rend le champ optionnel
    private byte[] emploiFile;

    // Getters et Setters
    public Long getId_enseignant() {
        return id_enseignant;
    }

    public void setId_enseignant(Long id_enseignant) {
        this.id_enseignant = id_enseignant;
    }

    public String getNom_enseignant() {
        return nom_enseignant;
    }

    public void setNom_enseignant(String nom_enseignant) {
        this.nom_enseignant = nom_enseignant;
    }

    public String getPrenom_enseignant() {
        return prenom_enseignant;
    }

    public void setPrenom_enseignant(String prenom_enseignant) {
        this.prenom_enseignant = prenom_enseignant;
    }

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public byte[] getEmploiFile() {
        return emploiFile;
    }

    public void setEmploiFile(byte[] emploiFile) {
        this.emploiFile = emploiFile;
    }
}
