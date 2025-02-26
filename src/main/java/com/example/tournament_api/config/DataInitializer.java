package com.example.tournamentapi.config;

import com.example.tournamentapi.model.Tournament;
import com.example.tournamentapi.repository.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {
    
    private final TournamentRepository tournamentRepository;
    
    @Autowired
    public DataInitializer(TournamentRepository tournamentRepository) {
        this.tournamentRepository = tournamentRepository;
    }
    
    @Override
    public void run(String... args) {
        // Only seed if database is empty
        if (tournamentRepository.count() == 0) {
            // Upcoming Tournaments
            Tournament t1 = new Tournament();
            t1.setTitle("Winter Clash 2025");
            t1.setGameName("Valorant");
            t1.setDate(LocalDate.now().plusDays(12));
            t1.setPrizePool(new BigDecimal("5000.00"));
            t1.setStatus("Upcoming");
            t1.setDescription("5v5, Best of 3, Open to all.");
            
            Tournament t2 = new Tournament();
            t2.setTitle("Apex Legends Showdown");
            t2.setGameName("Apex Legends");
            t2.setDate(LocalDate.now().minusDays(6));
            t2.setPrizePool(new BigDecimal("3000.00"));
            t2.setStatus("Completed");
            t2.setDescription("Trios, $1000 per player.");
            
            Tournament t3 = new Tournament();
            t3.setTitle("CS:GO Pro League");
            t3.setGameName("CS:GO");
            t3.setDate(LocalDate.now().plusDays(34));
            t3.setPrizePool(new BigDecimal("10000.00"));
            t3.setStatus("Upcoming");
            t3.setDescription("5v5, Bracket Style.");
            
            Tournament t4 = new Tournament();
            t4.setTitle("Console Masters Series");
            t4.setGameName("Call of Duty: Warzone");
            t4.setDate(LocalDate.now().plusDays(7));
            t4.setPrizePool(new BigDecimal("30000.00"));
            t4.setStatus("Upcoming");
            t4.setDescription("Console-only tournament featuring the best controller players. Squad-based competition with point-based scoring system across multiple matches.");
            
            Tournament t5 = new Tournament();
            t5.setTitle("Grand Strategy Invitational");
            t5.setGameName("Civilization VI");
            t5.setDate(LocalDate.now().plusDays(21));
            t5.setPrizePool(new BigDecimal("15000.00"));
            t5.setStatus("Upcoming");
            t5.setDescription("An epic battle of wits in this turn-based strategy competition. Players must demonstrate mastery of diplomacy, warfare, and economic development to emerge victorious.");
            
            Tournament t6 = new Tournament();
            t6.setTitle("Mobile Legends Championship");
            t6.setGameName("Mobile Legends: Bang Bang");
            t6.setDate(LocalDate.now().plusDays(10));
            t6.setPrizePool(new BigDecimal("25000.00"));
            t6.setStatus("Upcoming");
            t6.setDescription("The premier mobile MOBA tournament featuring qualifiers from Southeast Asia, Europe, and North America. Teams of five compete in this fast-paced strategic competition.");
            
            Tournament t7 = new Tournament();
            t7.setTitle("Fighting Game Summit");
            t7.setGameName("Street Fighter 6");
            t7.setDate(LocalDate.now().plusDays(60));
            t7.setPrizePool(new BigDecimal("40000.00"));
            t7.setStatus("Upcoming");
            t7.setDescription("The ultimate fighting game tournament featuring the world's best players. Double elimination bracket with best-of-five finals. Side tournaments for other fighting games will also be available.");
            
            // Completed Tournaments
            Tournament t8 = new Tournament();
            t8.setTitle("Racing Grand Prix");
            t8.setGameName("Gran Turismo 7");
            t8.setDate(LocalDate.now().minusDays(10));
            t8.setPrizePool(new BigDecimal("25000.00"));
            t8.setStatus("Completed");
            t8.setDescription("Professional racing simulation tournament for elite drivers. Featured custom tracks and limited car selections. Winner: RacingLegend44.");
            
            // Save all tournaments
            List<Tournament> tournaments = Arrays.asList(
                t1, t2, t3, t4, t5, t6, t7, t8
            );
            
            tournamentRepository.saveAll(tournaments);
            
            System.out.println("Database seeded with " + tournaments.size() + " tournaments!");
        }
    }
}