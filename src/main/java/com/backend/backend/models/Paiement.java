package com.backend.backend.models;
import jakarta.persistence.*;

@Entity
public class Paiement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paiement")
    private Long id_paiement;

    @Column(name = "total_seances")
    private int total_seances;

    @Column(name = "total_enseignant")
    private double total_enseignant;

    @Column(name = "total_administration")
    private double total_administration;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_etude")
    private Etude etude;


    // Getters et Setters

    public Long getId_paiement() {
        return id_paiement;
    }

    public void setId_paiement(Long id_paiement) {
        this.id_paiement = id_paiement;
    }

    public int getTotal_seances() {
        return total_seances;
    }

    public void setTotal_seances(int total_seances) {
        this.total_seances = total_seances;
    }

    public double getTotal_enseignant() {
        return total_enseignant;
    }

    public void setTotal_enseignant(double total_enseignant) {
        this.total_enseignant = total_enseignant;
    }

    public double getTotal_administration() {
        return total_administration;
    }

    public void setTotal_administration(double total_administration) {
        this.total_administration = total_administration;
    }

    public Etude getEtude() {
        return etude;
    }

    public void setEtude(Etude etude) {
        this.etude = etude;
    }
}
