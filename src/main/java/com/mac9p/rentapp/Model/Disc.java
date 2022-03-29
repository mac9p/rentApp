package com.mac9p.rentapp.Model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Disc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Integer price;

    @Enumerated(value = EnumType.STRING)
    private GenreOfMovie genre;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate yearOfPremiere;

    public Disc(String title, Integer price, LocalDate yearOfPremiere, GenreOfMovie genre,String description) {
        this.title = title;
        this.price = price;
        this.yearOfPremiere = yearOfPremiere;
        this.genre = genre;
        this.description = description;
    }

    private boolean isLent;

    private String description;

    @ManyToOne
    private User userRenting;
}
