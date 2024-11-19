package com.backend.backend.controllers;

import org.springframework.web.multipart.MultipartFile;

import com.backend.backend.models.Enseignant;
import com.backend.backend.services.EnseignantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/enseignants")
public class EnseignantController {

    @Autowired
    private EnseignantService enseignantService;

    // Récupérer tous les enseignants
    @GetMapping
    public List<Enseignant> getAll() {
        return enseignantService.getAllEnseignants();
    }

    // Récupérer un enseignant par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Enseignant> getById(@PathVariable Long id) {
        Enseignant enseignant = enseignantService.getEnseignantById(id);
        return (enseignant != null) ? ResponseEntity.ok(enseignant) : ResponseEntity.notFound().build();
    }

    // Créer un nouvel enseignant
    @PostMapping
    public Enseignant create(@RequestBody Enseignant enseignant) {
        return enseignantService.saveEnseignant(enseignant);
    }

    // Mettre à jour un enseignant existant
    @PutMapping("/{id}")
    public ResponseEntity<Enseignant> update(@PathVariable Long id, @RequestBody Enseignant enseignant) {
        if (enseignantService.getEnseignantById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        enseignant.setId_enseignant(id);
        return ResponseEntity.ok(enseignantService.saveEnseignant(enseignant));
    }

    // Supprimer un enseignant par son ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (enseignantService.getEnseignantById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        enseignantService.deleteEnseignant(id);
        return ResponseEntity.noContent().build();
    }

    // Télécharger le fichier d'emploi pour un enseignant
    @PostMapping("/{id}/emploi")
    public ResponseEntity<String> uploadEmploi(@PathVariable Long id, @RequestParam("file") MultipartFile file) {
        // Vérifier si l'enseignant existe
        Enseignant enseignant = enseignantService.getEnseignantById(id);
        if (enseignant == null) {
            return ResponseEntity.notFound().build();
        }

        try {
            // Vérifier si le fichier n'est pas vide
            if (file.isEmpty()) {
                return ResponseEntity.badRequest().body("Le fichier est vide.");
            }

            // Stocker le fichier sous forme de tableau d'octets dans l'entité enseignant
            enseignant.setEmploiFile(file.getBytes());
            enseignantService.saveEnseignant(enseignant); // Sauvegarder dans la base de données

            return ResponseEntity.ok("Fichier téléchargé avec succès !");
        } catch (IOException e) {
            // Gérer les erreurs d'entrée/sortie
            return ResponseEntity.status(500).body("Erreur lors du téléchargement du fichier : " + e.getMessage());
        }
    }


    // Supprimer le fichier d'emploi d'un enseignant
    @DeleteMapping("/{id}/emploi")
    public ResponseEntity<Void> deleteEmploiFile(@PathVariable Long id) {
        Enseignant enseignant = enseignantService.getEnseignantById(id);
        if (enseignant == null) {
            return ResponseEntity.notFound().build();
        }

        enseignant.setEmploiFile(null); // Supprimer le fichier d'emploi
        enseignantService.saveEnseignant(enseignant);
        return ResponseEntity.noContent().build();
    }
}
