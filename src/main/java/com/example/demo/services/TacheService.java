package com.example.demo.services;

import com.example.demo.models.Tache;
import com.example.demo.repository.TacheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class TacheService implements iTacheService {

    private final TacheRepository tacheRepository;

    @Autowired
    public TacheService(TacheRepository tacheRepository) {
        this.tacheRepository = tacheRepository;
    }

    @Override
    public Tache ajouterTache(Tache tache) {
        return tacheRepository.save(tache);
    }

    @Override
    public void supprimerTache(String idTache) {
        tacheRepository.deleteById(idTache);
    }

    @Override
    public Tache getTache(String idTache) {
        return tacheRepository.findById(idTache).orElse(null);
    }

    @Override
    public Tache modifierTache(Tache tache) {
        return tacheRepository.save(tache);
    }

    @Override
    public List<Tache> getAllTache() {
        return tacheRepository.findAll();
    }

    @Override
    public List<Tache> getTachesByDateEchec(LocalDate dateEchec) {
        return tacheRepository.findByDateEchec(dateEchec);
    }

    @Override
    public List<Tache> getTachesByCategory(String category) {
        return tacheRepository.findByCategory(category);
    }

    @Override
    public List<Tache> getTachesByCategoryAndDateEchec(String category, LocalDate dateEchec) {
        return tacheRepository.findByCategoryAndDateEchec(category, dateEchec);
    }
    @Override
    public long countTotalTaches() {
        return tacheRepository.count();
    }

    @Override
    public long countTachesByEtat(boolean etat) {
        return tacheRepository.countByEtats(etat);
    }

    @Override
    public long countTachesOverdue() {
        Date now = new Date();
        return tacheRepository.countByDateEchecBeforeAndEtats(now, false);
    }



    @Override
    public void moveToTrash(String idTache) {
        Tache tache = tacheRepository.findById(idTache).orElseThrow(() -> new RuntimeException("Task not found"));
        tache.setInTrash(true);
        tacheRepository.save(tache);
    }

    @Override
    public void restoreFromTrash(String idTache) {
        Tache tache = tacheRepository.findById(idTache).orElseThrow(() -> new RuntimeException("Task not found"));
        tache.setInTrash(false);
        tacheRepository.save(tache);
    }

    @Override
    public void deletePermanently(String idTache) {
        tacheRepository.deleteById(idTache);
    }

    @Override
    public List<Tache> getTasksInTrash() {
        return tacheRepository.findByIsInTrash(true);
    }
}
