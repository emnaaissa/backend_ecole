package com.backend.backend.services;

import com.backend.backend.models.Eleve;
import com.backend.backend.models.EleveEtude;
import com.backend.backend.models.Etude;
import com.backend.backend.repositories.EleveEtudeRepository;
import com.backend.backend.repositories.EleveRepository;
import com.backend.backend.repositories.EtudeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EleveEtudeService {
    @Autowired
    private EleveEtudeRepository eleveEtudeRepository;

    public List<EleveEtude> getAllEleveEtudes() {
        return eleveEtudeRepository.findAll();
    }

    public Optional<EleveEtude> getEleveEtudeById(Long id) {
        return eleveEtudeRepository.findById(id);
    }


    @Autowired
    private EleveRepository eleveRepository;

    @Autowired
    private EtudeRepository etudeRepository;

    public EleveEtude saveEleveEtude(EleveEtude eleveEtude) {
        // Vérifiez si l'élève et l'étude existent
        Optional<Eleve> eleveOpt = eleveRepository.findById(eleveEtude.getEleve().getId_eleve());
        Optional<Etude> etudeOpt = etudeRepository.findById(eleveEtude.getEtude().getId_etude());

        if (eleveOpt.isPresent() && etudeOpt.isPresent()) {
            eleveEtude.setEleve(eleveOpt.get());
            eleveEtude.setEtude(etudeOpt.get());
            return eleveEtudeRepository.save(eleveEtude);
        } else {
            throw new RuntimeException("Élève ou Étude non trouvés");
        }
    }

    public void deleteEleveEtude(Long id) {
        eleveEtudeRepository.deleteById(id);
    }
}
