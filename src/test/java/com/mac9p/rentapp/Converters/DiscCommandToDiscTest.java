package com.mac9p.rentapp.Converters;

import com.mac9p.rentapp.Commands.DiscCommand;
import com.mac9p.rentapp.Model.Disc;
import com.mac9p.rentapp.Model.GenreOfMovie;
import com.mac9p.rentapp.Model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DiscCommandToDiscTest {
    private static final Long ID_VALUE = 1L;
    private static final String TITLE = "ExampleTitle";
    private static final GenreOfMovie GENRE = GenreOfMovie.ACTION;
    private static final LocalDate DATE = LocalDate.of(2002,6,20);
    private static final Boolean IS_LENT = true;
    private static final String DESCRIPTION = "ExampleDescription";
    private static final User USER = new User();

    private DiscCommandToDisc commandToDisc;

    @BeforeEach
    void setUp() {
        commandToDisc = new DiscCommandToDisc();
    }

    @Test
    void convert() {
        //given
        DiscCommand command = new DiscCommand();
        command.setId(ID_VALUE);
        command.setTitle(TITLE);
        command.setGenre(GENRE);
        command.setYearOfPremiere(DATE);
        command.setLent(IS_LENT);
        command.setDescription(DESCRIPTION);
        command.setUserRenting(USER);

        //when
        Disc disc = commandToDisc.convert(command);

        //then
        assertNotNull(disc);
        assertEquals(disc.getId(),command.getId());
        assertEquals(disc.getTitle(),command.getTitle());
        assertEquals(disc.getGenre(),command.getGenre());
        assertEquals(disc.getYearOfPremiere(),command.getYearOfPremiere());

    }

}