package com.backend.backend.models;
import jakarta.persistence.*;

@Entity
public class Etude {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_etude")
    private Long id_etude;

    @Column(name = "matiere")
    private String matiere;

    @Column(name = "niveau")
    private String niveau;

    @ManyToOne
    @JoinColumn(name = "id_enseignant")
    private Enseignant enseignant;


    public Long getId_etude() {
        return id_etude;
    }

    public void setId_etude(Long id_etude) {
        this.id_etude = id_etude;
    }

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public Enseignant getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }
}
