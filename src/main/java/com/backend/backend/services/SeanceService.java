package com.backend.backend.services;

import com.backend.backend.models.Seance;
import com.backend.backend.repositories.SeanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeanceService {

    private final SeanceRepository seanceRepository;

    @Autowired
    public SeanceService(SeanceRepository seanceRepository) {
        this.seanceRepository = seanceRepository;
    }

    public List<Seance> getAllSeances() {
        return seanceRepository.findAll();
    }

    public Optional<Seance> getSeanceById(Long id) {
        return seanceRepository.findById(id);
    }

    public Seance createSeance(Seance seance) {
        return seanceRepository.save(seance);
    }

    public Seance updateSeance(Long id, Seance seanceDetails) {
        Seance seance = seanceRepository.findById(id).orElseThrow(() -> new RuntimeException("Seance not found"));
        seance.setDate_seance(seanceDetails.getDate_seance());
        seance.setEtude(seanceDetails.getEtude());
        return seanceRepository.save(seance);
    }

    public void deleteSeance(Long id) {
        Seance seance = seanceRepository.findById(id).orElseThrow(() -> new RuntimeException("Seance not found"));
        seanceRepository.delete(seance);
    }
}
