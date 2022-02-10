package com.mac9p.rentapp.Model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Data
public class Disc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Integer price;

    @Enumerated(value = EnumType.STRING)
    private GenreOfMovie genre;

    private LocalDate yearOfPremiere;

    public Disc(String title, Integer price, LocalDate yearOfPremiere, GenreOfMovie genre) {
        this.title = title;
        this.price = price;
        this.yearOfPremiere = yearOfPremiere;
        this.genre = genre;
    }
}
