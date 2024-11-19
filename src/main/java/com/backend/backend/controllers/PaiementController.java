package com.backend.backend.controllers;

import com.backend.backend.models.Paiement;
import com.backend.backend.services.PaiementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/paiements")
public class PaiementController {

    @Autowired
    private PaiementService paiementService;

    // Récupérer tous les paiements
    @GetMapping
    public List<Paiement> getAll() {
        return paiementService.getAllPaiements();
    }

    // Récupérer un paiement par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Paiement> getById(@PathVariable Long id) {
        Paiement paiement = paiementService.getPaiementById(id);
        return (paiement != null) ? ResponseEntity.ok(paiement) : ResponseEntity.notFound().build();
    }

    // Créer un nouveau paiement
    @PostMapping
    public Paiement create(@RequestBody Paiement paiement) {
        return paiementService.savePaiement(paiement);
    }

    // Mettre à jour un paiement existant
    @PutMapping("/{id}")
    public ResponseEntity<Paiement> update(@PathVariable Long id, @RequestBody Paiement paiement) {
        if (paiementService.getPaiementById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        paiement.setId_paiement(id);
        return ResponseEntity.ok(paiementService.savePaiement(paiement));
    }

    // Supprimer un paiement par son ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (paiementService.getPaiementById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        paiementService.deletePaiement(id);
        return ResponseEntity.noContent().build();
    }
}
