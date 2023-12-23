package com.example.demo.services;

import com.example.demo.models.Tache;

import java.time.LocalDate;
import java.util.List;

public interface iTacheService {
    Tache ajouterTache(Tache tache);

    void supprimerTache(String idTache);

    Tache getTache(String idTache);

    Tache modifierTache(Tache tache);

    List<Tache> getAllTache();

    List<Tache> getTachesByDateEchec(LocalDate dateEchec);

    List<Tache> getTachesByCategory(String category);

    List<Tache> getTachesByCategoryAndDateEchec(String category, LocalDate dateEchec);
    long countTotalTaches();

    long countTachesByEtat(boolean etat);

    long countTachesOverdue();

    void moveToTrash(String idTache);

    void restoreFromTrash(String idTache);

    void deletePermanently(String idTache);

    List<Tache> getTasksInTrash();

}
