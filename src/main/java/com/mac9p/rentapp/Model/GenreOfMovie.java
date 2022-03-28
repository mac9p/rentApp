package com.mac9p.rentapp.Model;

import org.springframework.stereotype.Component;

import javax.persistence.*;

public enum GenreOfMovie {
    ADVENTURE("ADVENTURE"),ACTION("ACTION"),
    ROMANCE("ROMANCE"),SCIFI("SCI-FI"),
    HISTORICAL("HISTORICAL"),DOCUMENT("DOCUMENT"),
    HORROR("HORROR"),THRILLER("THRILLER");

    GenreOfMovie(String genre) {

    }
}
