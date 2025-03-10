package com.example.tournamentapi.controller;

import com.example.tournamentapi.model.Tournament;
import com.example.tournamentapi.service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/tournaments")
@CrossOrigin(origins = {"http://localhost:3000", "https://hok-seven.vercel.app", "https://whitecar.ddnsking.com"})
public class TournamentController {

    private final TournamentService tournamentService;

    @Autowired
    public TournamentController(TournamentService tournamentService) {
        this.tournamentService = tournamentService;
    }

    @GetMapping
    public ResponseEntity<List<Tournament>> getAllTournaments(
            @RequestParam(required = false) String status) {

        if (status != null && !status.isEmpty()) {
            return new ResponseEntity<>(
                tournamentService.getTournamentsByStatus(status), 
                HttpStatus.OK
            );
        }

        return new ResponseEntity<>(tournamentService.getAllTournaments(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tournament> getTournamentById(@PathVariable Long id) {
        return tournamentService.getTournamentById(id)
                .map(tournament -> new ResponseEntity<>(tournament, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/create")
    public ResponseEntity<Tournament> createTournament(@RequestBody @Valid Tournament tournament) {
        return new ResponseEntity<>(tournamentService.saveTournament(tournament), HttpStatus.CREATED);
    }
}
