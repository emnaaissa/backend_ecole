package com.backend.backend.controllers;

import com.backend.backend.models.Classe;
import com.backend.backend.services.ClasseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/classes")
public class ClasseController {

    @Autowired
    private ClasseService classeService;

    // Récupérer toutes les classes
    @GetMapping
    public List<Classe> getAll() {
        return classeService.getAllClasses();
    }

    // Récupérer une classe par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Classe> getById(@PathVariable Long id) {
        Classe classe = classeService.getClasseById(id);
        return (classe != null) ? ResponseEntity.ok(classe) : ResponseEntity.notFound().build();
    }

    // Créer une nouvelle classe
    @PostMapping
    public Classe create(@RequestBody Classe classe) {
        return classeService.saveClasse(classe);
    }

    // Mettre à jour une classe existante
    @PutMapping("/{id}")
    public ResponseEntity<Classe> update(@PathVariable Long id, @RequestBody Classe classe) {
        if (classeService.getClasseById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        classe.setId_classe(id);
        return ResponseEntity.ok(classeService.saveClasse(classe));
    }

    // Supprimer une classe par son ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (classeService.getClasseById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        classeService.deleteClasse(id);
        return ResponseEntity.noContent().build();
    }
}
