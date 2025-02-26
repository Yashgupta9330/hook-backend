package com.example.tournamentapi.service;

import com.example.tournamentapi.model.Tournament;
import com.example.tournamentapi.repository.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TournamentService {
    
    private final TournamentRepository tournamentRepository;
    
    @Autowired
    public TournamentService(TournamentRepository tournamentRepository) {
        this.tournamentRepository = tournamentRepository;
    }
    
    public List<Tournament> getAllTournaments() {
        return tournamentRepository.findAll();
    }
    
    public Optional<Tournament> getTournamentById(Long id) {
        return tournamentRepository.findById(id);
    }
    
    public List<Tournament> getTournamentsByStatus(String status) {
        return tournamentRepository.findByStatus(status);
    }
    
    public Tournament saveTournament(Tournament tournament) {
        return tournamentRepository.save(tournament);
    }
}