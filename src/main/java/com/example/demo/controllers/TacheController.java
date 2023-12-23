package com.example.demo.controllers;


import com.example.demo.models.Tache;
import com.example.demo.services.iTacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/taches")
public class TacheController {

    @Autowired
    private iTacheService tacheService;

    @PostMapping
    public ResponseEntity<Tache> ajouterTache(@RequestBody Tache tache) {
        Tache nouvelleTache = tacheService.ajouterTache(tache);
        return ResponseEntity.ok(nouvelleTache);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerTache(@PathVariable String id) {
        tacheService.supprimerTache(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tache> getTache(@PathVariable String id) {
        Tache tache = tacheService.getTache(id);
        return ResponseEntity.ok(tache);
    }

    @PutMapping
    public ResponseEntity<Tache> modifierTache(@RequestBody Tache tache) {
        Tache tacheModifiee = tacheService.modifierTache(tache);
        return ResponseEntity.ok(tacheModifiee);
    }

    @GetMapping
    public ResponseEntity<List<Tache>> getAllTache() {
        List<Tache> taches = tacheService.getAllTache();
        return ResponseEntity.ok(taches);
    }

    @GetMapping("/dateEchec/{date}")
    public ResponseEntity<List<Tache>> getTachesByDateEchec(@PathVariable LocalDate date) {
        List<Tache> taches = tacheService.getTachesByDateEchec(date);
        return ResponseEntity.ok(taches);
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Tache>> getTachesByCategory(@PathVariable String category) {
        List<Tache> taches = tacheService.getTachesByCategory(category);
        return ResponseEntity.ok(taches);
    }

    @GetMapping("/category/{category}/dateEchec/{date}")
    public ResponseEntity<List<Tache>> getTachesByCategoryAndDateEchec(@PathVariable String category, @PathVariable LocalDate date) {
        List<Tache> taches = tacheService.getTachesByCategoryAndDateEchec(category, date);
        return ResponseEntity.ok(taches);
    }

    // Add more endpoints as needed for statistics and reporting
    // Example for counting total tasks
    @GetMapping("/stats/total")
    public ResponseEntity<Long> getTotalTaskCount() {
        long totalTasksCount = tacheService.countTotalTaches();
        return ResponseEntity.ok(totalTasksCount);
    }



    @PutMapping("/{id}/trash")
    public ResponseEntity<Void> moveToTrash(@PathVariable String id) {
        tacheService.moveToTrash(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/restore")
    public ResponseEntity<Void> restoreFromTrash(@PathVariable String id) {
        tacheService.restoreFromTrash(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}/permanent")
    public ResponseEntity<Void> deletePermanently(@PathVariable String id) {
        tacheService.deletePermanently(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/trash")
    public ResponseEntity<List<Tache>> getTasksInTrash() {
        List<Tache> trashTasks = tacheService.getTasksInTrash();
        return ResponseEntity.ok(trashTasks);
    }
}
