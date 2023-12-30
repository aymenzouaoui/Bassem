package com.example.demo.controllers;



import com.example.demo.models.Tache;
import com.example.demo.services.iTacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trash")
public class TrashController {

    private final iTacheService tacheService;

    @Autowired
    public TrashController(iTacheService tacheService) {
        this.tacheService = tacheService;
    }

    // Endpoint to retrieve all tasks in the trash
    @GetMapping
    public ResponseEntity<List<Tache>> getAllTrashedTasks() {
        List<Tache> trashedTasks = tacheService.getTasksInTrash();
        return ResponseEntity.ok(trashedTasks);
    }

    // Endpoint to move a task to the trash
    @PutMapping("/{id}/move-to-trash")
    public ResponseEntity<Void> moveToTrash(@PathVariable String id) {
        tacheService.moveToTrash(id);
        return ResponseEntity.ok().build();
    }

    // Endpoint to restore a task from the trash
    @PutMapping("/{id}/restore")
    public ResponseEntity<Void> restoreFromTrash(@PathVariable String id) {
        tacheService.restoreFromTrash(id);
        return ResponseEntity.ok().build();
    }

    // Endpoint to delete a task permanently from the trash
    @DeleteMapping("/{id}/delete-permanently")
    public ResponseEntity<Void> deletePermanently(@PathVariable String id) {
        tacheService.deletePermanently(id);
        return ResponseEntity.noContent().build();
    }
}
