package com.mac9p.rentapp.Services;

import com.mac9p.rentapp.Model.Disc;
import com.mac9p.rentapp.Model.GenreOfMovie;
import com.mac9p.rentapp.Model.User;
import com.mac9p.rentapp.Repositories.DiscRepository;
import com.mac9p.rentapp.Repositories.UserRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class DiscServiceTest {
    @Mock
    private DiscRepository discRepository;
    @InjectMocks
    @Autowired
    private DiscService service;

    private static Disc disc;
    @BeforeAll
    static void setUp() {
        disc = new Disc(1L,
                "ExTitle",
                30,
                GenreOfMovie.HORROR,
                LocalDate.of(2002,10,30),
                false,
                "desc",
                new User());

    }

    @Test
    void addDisc() {
        Disc createdDisc = service.addDisc(disc);

        assertNotNull(createdDisc);
        assertSame(disc,createdDisc);
    }

    @Test
    void deleteDiscById() {
    }

    @Test
    void getAllDiscs() {
    }

    @Test
    void getDiscById() {
    }

    @Test
    void getDiscsByGenre() {
    }

    @Test
    void findDiscByTitle() {
    }
}