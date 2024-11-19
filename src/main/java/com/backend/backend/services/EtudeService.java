package com.backend.backend.services;

import com.backend.backend.models.Etude;
import com.backend.backend.models.Enseignant;
import com.backend.backend.repositories.EtudeRepository;
import com.backend.backend.repositories.EnseignantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtudeService {

    @Autowired
    private EtudeRepository etudeRepository;

    @Autowired
    private EnseignantRepository enseignantRepository;

    // Récupérer toutes les études
    public List<Etude> getAllEtudes() {
        return etudeRepository.findAll();
    }

    // Récupérer une étude par son ID
    public Etude getEtudeById(Long id) {
        return etudeRepository.findById(id).orElse(null);
    }

    // Créer une nouvelle étude avec un enseignant
    public Etude saveEtude(Etude etude) {
        // Vérifier si l'enseignant existe
        Enseignant enseignant = enseignantRepository.findById(etude.getEnseignant().getId_enseignant()).orElse(null);
        if (enseignant != null) {
            etude.setEnseignant(enseignant); // Associer l'enseignant à l'étude
            return etudeRepository.save(etude); // Sauvegarder l'étude
        }
        return null; // Retourner null si l'enseignant n'existe pas
    }

    // Mettre à jour une étude existante
    public Etude updateEtude(Long id, Etude etude) {
        // Vérifier si l'étude existe
        if (etudeRepository.existsById(id)) {
            etude.setId_etude(id); // Mettre à jour l'ID
            // Vérifier si l'enseignant existe
            Enseignant enseignant = enseignantRepository.findById(etude.getEnseignant().getId_enseignant()).orElse(null);
            if (enseignant != null) {
                etude.setEnseignant(enseignant); // Associer l'enseignant à l'étude
                return etudeRepository.save(etude); // Sauvegarder l'étude mise à jour
            }
        }
        return null; // Retourner null si l'étude ou l'enseignant n'existe pas
    }

    // Supprimer une étude par son ID
    public void deleteEtude(Long id) {
        if (etudeRepository.existsById(id)) {
            etudeRepository.deleteById(id); // Supprimer l'étude
        }
    }
}
