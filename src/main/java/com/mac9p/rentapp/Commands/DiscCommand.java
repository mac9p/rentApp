package com.mac9p.rentapp.Commands;

import com.mac9p.rentapp.Model.GenreOfMovie;
import com.mac9p.rentapp.Model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class DiscCommand {
    private Long id;
    private String title;
    private Integer price;
    private GenreOfMovie genre;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate yearOfPremiere;
    private boolean isLent;
    private String description;
    private User userRenting;
}
