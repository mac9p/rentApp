package com.mac9p.rentapp.Commands;

import com.mac9p.rentapp.Model.GenreOfMovie;
import com.mac9p.rentapp.Model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class DiscCommand {
    private Long id;
    private String title;
    private Integer price;
    private GenreOfMovie genre;
    private LocalDate yearOfPremiere;
    private boolean isLent;
    private String description;
    private User userRenting;
}
