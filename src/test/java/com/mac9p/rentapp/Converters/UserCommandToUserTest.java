package com.mac9p.rentapp.Converters;

import com.mac9p.rentapp.Commands.UserCommand;
import com.mac9p.rentapp.Model.Disc;
import com.mac9p.rentapp.Model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserCommandToUserTest {

    private static final Long ID = 1l;
    private static final List<Disc> DISC_LIST = new ArrayList<>();
    private static final String FIRST_NAME = "ExName";
    private static final String LAST_NAME = "ExLastName";

    private UserCommandToUser converter;
    @BeforeEach
    void setUp() {
        converter = new UserCommandToUser();
    }

    @Test
    void convert() {
        //given
        UserCommand userCommand = new UserCommand(ID,
                DISC_LIST,
                FIRST_NAME,
                LAST_NAME);
        //when
        User user = converter.convert(userCommand);

        //then

        assertNotNull(user);

        assertEquals(userCommand.getId(),user.getId());
        assertEquals(userCommand.getDiscsRented(),user.getDiscsRented());
        assertEquals(userCommand.getFirstName(),user.getFirstName());
        assertEquals(userCommand.getLastName(),user.getLastName());
    }
}