package com.example.tournamentapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "tournaments")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tournament {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "Title is mandatory")
    @Column(nullable = false)
    private String title;
    
    @NotBlank(message = "Game name is mandatory")
    @Column(name = "game_name", nullable = false)
    private String gameName;
    
    @NotNull(message = "Date is mandatory")
    @Column(nullable = false)
    private LocalDate date;
    
    @NotNull(message = "Prize pool is mandatory")
    @DecimalMin(value = "0.1", message = "Prize pool must be greater than zero")
    @Column(name = "prize_pool", nullable = false)
    private BigDecimal prizePool;
    
    @NotBlank(message = "Status is mandatory")
    @Pattern(regexp = "Upcoming|Completed", message = "Status must be either 'Upcoming' or 'Completed'")
    @Column(nullable = false)
    private String status;
    
    @Column(columnDefinition = "TEXT")
    private String description;
}
