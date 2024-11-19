package com.backend.backend.controllers;

import com.backend.backend.models.Etude;
import com.backend.backend.services.EtudeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/etudes")
public class EtudeController {

    @Autowired
    private EtudeService etudeService;

    // Récupérer toutes les études
    @GetMapping
    public List<Etude> getAll() {
        return etudeService.getAllEtudes();
    }

    // Récupérer une étude par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Etude> getById(@PathVariable Long id) {
        Etude etude = etudeService.getEtudeById(id);
        return (etude != null) ? ResponseEntity.ok(etude) : ResponseEntity.notFound().build();
    }

    // Créer une nouvelle étude
    @PostMapping
    public Etude create(@RequestBody Etude etude) {
        return etudeService.saveEtude(etude);
    }

    // Mettre à jour une étude existante
    @PutMapping("/{id}")
    public ResponseEntity<Etude> update(@PathVariable Long id, @RequestBody Etude etude) {
        if (etudeService.getEtudeById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        etude.setId_etude(id);
        return ResponseEntity.ok(etudeService.saveEtude(etude));
    }

    // Supprimer une étude par son ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (etudeService.getEtudeById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        etudeService.deleteEtude(id);
        return ResponseEntity.noContent().build();
    }
}
