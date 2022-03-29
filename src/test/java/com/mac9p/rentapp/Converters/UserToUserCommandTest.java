package com.mac9p.rentapp.Converters;

import com.mac9p.rentapp.Commands.UserCommand;
import com.mac9p.rentapp.Model.Disc;
import com.mac9p.rentapp.Model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserToUserCommandTest {
    private static final Long ID = 1l;
    private static final List<Disc> DISC_LIST = new ArrayList<>();
    private static final String FIRST_NAME = "EX_NAME";
    private static final String LAST_NAME = "EX_LAST_NAME";

    private UserToUserCommand converter;
    @BeforeEach
    void setUp() {
        converter = new UserToUserCommand();
    }

    @Test
    void convert() {
        //given
        User user = new User(ID,
                DISC_LIST,
                FIRST_NAME,
                LAST_NAME);

        //when
        UserCommand userCommand = converter.convert(user);

        //then
        assertNotNull(userCommand);

        assertEquals(userCommand.getId(),user.getId());
        assertEquals(userCommand.getDiscsRented(),user.getDiscsRented());
        assertEquals(userCommand.getFirstName(), user.getFirstName());
        assertEquals(userCommand.getLastName(), user.getLastName());

    }
}