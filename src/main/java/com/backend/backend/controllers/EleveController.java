package com.backend.backend.controllers;

import com.backend.backend.models.Eleve;
import com.backend.backend.models.Classe;
import com.backend.backend.repositories.ClasseRepository;
import com.backend.backend.repositories.EleveRepository;
import com.backend.backend.services.EleveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/eleves")
public class EleveController {

    @Autowired
    private EleveService eleveService;

    @Autowired
    private EleveRepository eleveRepository;

    @Autowired
    private ClasseRepository classeRepository;

    // Récupérer tous les élèves
    @GetMapping
    public List<Eleve> getAll() {
        return eleveService.getAllEleves(); // Utiliser le nom correct de la méthode
    }

    // Récupérer un élève par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Eleve> getById(@PathVariable Long id) {
        Eleve eleve = eleveService.getEleveById(id);
        return (eleve != null) ? ResponseEntity.ok(eleve) : ResponseEntity.notFound().build();
    }

    // Créer un nouvel élève
    @PostMapping
    public Eleve createEleve(@RequestBody Eleve eleve) {
        if (eleve.getIdClasse() != null) {
            Classe classe = classeRepository.findById(eleve.getIdClasse())
                    .orElseThrow(() -> new RuntimeException("Classe non trouvée"));
            eleve.setClasse(classe);
        }
        return eleveRepository.save(eleve);
    }

    // Mettre à jour un élève existant
    @PutMapping("/{id}")
    public ResponseEntity<Eleve> update(@PathVariable Long id, @RequestBody Eleve eleve) {
        if (eleveService.getEleveById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        eleve.setId_eleve(id); // Utiliser le bon nom de la méthode pour définir l'ID
        return ResponseEntity.ok(eleveService.saveEleve(eleve)); // Utiliser le nom correct de la méthode
    }

    // Supprimer un élève par son ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (eleveService.getEleveById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        eleveService.deleteEleve(id); // Utiliser le nom correct de la méthode
        return ResponseEntity.noContent().build();
    }
}
