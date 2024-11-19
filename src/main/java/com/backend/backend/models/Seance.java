package com.backend.backend.models;

import jakarta.persistence.*;

import java.util.Date;


@Entity
public class Seance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_seance")
    private Long id_seance;

    @Column(name = "date_seance")
    private Date date_seance;

    @ManyToOne
    @JoinColumn(name = "id_etude")
    private Etude etude;

    // Getters et Setters

    public Long getId_seance() {
        return id_seance;
    }

    public void setId_seance(Long id_seance) {
        this.id_seance = id_seance;
    }

    public Date getDate_seance() {
        return date_seance;
    }

    public void setDate_seance(Date date_seance) {
        this.date_seance = date_seance;
    }

    public Etude getEtude() {
        return etude;
    }

    public void setEtude(Etude etude) {
        this.etude = etude;
    }
}
