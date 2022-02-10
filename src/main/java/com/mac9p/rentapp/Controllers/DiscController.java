package com.mac9p.rentapp.Controllers;


import com.mac9p.rentapp.Model.Disc;
import com.mac9p.rentapp.Model.GenreOfMovie;
import com.mac9p.rentapp.Services.DiscService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/discs")
public class DiscController {
    private final DiscService discService;
    public DiscController(DiscService discService){
        this.discService = discService;

        discService.addDisc(new Disc("Pirates",50, LocalDate.of(2004,
                11,
                24), GenreOfMovie.ACTION));

        discService.addDisc(new Disc("HorrorMovie",
                20,
                LocalDate.of(1999,4,30),
                GenreOfMovie.HORROR));

        discService.addDisc(new Disc("MightyAdventure",
                70,
                LocalDate.of(2012,5,6),
                GenreOfMovie.ADVENTURE));
    }


    @GetMapping("/all")
    public List<Disc> getAllDiscs(){
        return discService.getAllDiscs();
    }

    @GetMapping("/id")
    public ResponseEntity<Disc> getDiscById(@RequestParam Long id){
        return new ResponseEntity<>(discService.getDiscById(id),HttpStatus.OK);
    }

    @GetMapping("/genre")
    public Disc getDiscByGenre(@RequestParam GenreOfMovie genre){
        return discService.getDiscByGenre(genre);
    }

    @PostMapping
    public Disc addDisc(@RequestBody Disc disc){
        return discService.addDisc(disc);
    }

    @PutMapping
    public Disc updateDisc(@RequestBody Disc disc){
        return discService.addDisc(disc);
    }
    @DeleteMapping("/{id}")
    public void deleteDiscById(@PathVariable("id") Long id){
        discService.deleteDiscById(id);
    }

    @GetMapping("/title")
    public Disc findDiscByTitle(@RequestParam String title){
        return discService.findDiscByTitle(title);
    }
}
