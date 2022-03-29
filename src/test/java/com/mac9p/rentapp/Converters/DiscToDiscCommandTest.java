package com.mac9p.rentapp.Converters;

import com.mac9p.rentapp.Commands.DiscCommand;
import com.mac9p.rentapp.Model.Disc;
import com.mac9p.rentapp.Model.GenreOfMovie;
import com.mac9p.rentapp.Model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DiscToDiscCommandTest {
    private static final Long ID = 1l;
    private static final String TITLE = "EX_TITLE";
    private static final Integer PRICE = 22;
    private static final GenreOfMovie GENRE = GenreOfMovie.DOCUMENT;
    private static final LocalDate DATE = LocalDate.of(2003,11,12);
    private static final boolean IS_LENT = true;
    private static final String DESCRIPTION = "EX_DESC";
    private static final User USER_RENTING = new User();

    private DiscToDiscCommand converter;
    @BeforeEach
    void setUp() {
        converter = new DiscToDiscCommand();
    }

    @Test
    void convert() {
        //given
        Disc disc = new Disc(ID,
                TITLE,
                PRICE,
                GENRE,
                DATE,
                IS_LENT,
                DESCRIPTION,
                USER_RENTING);

        //when
        DiscCommand command = converter.convert(disc);

        //then

        assertNotNull(command);

        assertEquals(command.getId(),disc.getId());
        assertEquals(command.getTitle(),disc.getTitle());
        assertEquals(command.getPrice(),disc.getPrice());
        assertEquals(command.getGenre(),disc.getGenre());
        assertEquals(command.getYearOfPremiere(),disc.getYearOfPremiere());
        assertEquals(command.isLent(),disc.isLent());
        assertEquals(command.getDescription(),disc.getDescription());
        assertEquals(command.getUserRenting(),disc.getUserRenting());
    }
}