package com.backend.backend.controllers;

import com.backend.backend.models.Presence;
import com.backend.backend.services.PresenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/presences")
public class PresenceController {

    @Autowired
    private PresenceService presenceService;

    // Récupérer toutes les présences
    @GetMapping
    public List<Presence> getAll() {
        return presenceService.getAllPresences();
    }

    // Récupérer une présence par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Presence> getById(@PathVariable Long id) {
        Presence presence = presenceService.getPresenceById(id);
        return (presence != null) ? ResponseEntity.ok(presence) : ResponseEntity.notFound().build();
    }

    // Créer une nouvelle présence
    @PostMapping
    public Presence create(@RequestBody Presence presence) {
        return presenceService.savePresence(presence);
    }

    // Mettre à jour une présence existante
    @PutMapping("/{id}")
    public ResponseEntity<Presence> update(@PathVariable Long id, @RequestBody Presence presence) {
        if (presenceService.getPresenceById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        presence.setId_presence(id);
        return ResponseEntity.ok(presenceService.savePresence(presence));
    }

    // Supprimer une présence par son ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (presenceService.getPresenceById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        presenceService.deletePresence(id);
        return ResponseEntity.noContent().build();
    }
}
