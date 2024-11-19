package com.backend.backend.controllers;

import com.backend.backend.models.EleveEtude;
import com.backend.backend.services.EleveEtudeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/eleve-etudes")
public class EleveEtudeController {

    @Autowired
    private EleveEtudeService eleveEtudeService;

    // Récupérer toutes les associations élève-étude
    @GetMapping
    public ResponseEntity<List<EleveEtude>> getAll() {
        List<EleveEtude> eleveEtudes = eleveEtudeService.getAllEleveEtudes();
        return ResponseEntity.ok(eleveEtudes);
    }

    // Récupérer une association élève-étude par son ID
    @GetMapping("/{id}")
    public ResponseEntity<EleveEtude> getById(@PathVariable Long id) {
        return eleveEtudeService.getEleveEtudeById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Créer une nouvelle association élève-étude
    @PostMapping
    public ResponseEntity<EleveEtude> create(@RequestBody EleveEtude eleveEtude) {
        EleveEtude createdEleveEtude = eleveEtudeService.saveEleveEtude(eleveEtude);
        return ResponseEntity.status(201).body(createdEleveEtude);
    }

    // Mettre à jour une association élève-étude existante
    @PutMapping("/{id}")
    public ResponseEntity<EleveEtude> update(@PathVariable Long id, @RequestBody EleveEtude eleveEtude) {
        if (!eleveEtudeService.getEleveEtudeById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        eleveEtude.setId(id);
        EleveEtude updatedEleveEtude = eleveEtudeService.saveEleveEtude(eleveEtude);
        return ResponseEntity.ok(updatedEleveEtude);
    }

    // Supprimer une association élève-étude par son ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!eleveEtudeService.getEleveEtudeById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        eleveEtudeService.deleteEleveEtude(id);
        return ResponseEntity.noContent().build();
    }
}
