package com.mac9p.rentapp.Converters;

import com.mac9p.rentapp.Commands.UserCommand;
import com.mac9p.rentapp.Model.User;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class UserToUserCommand implements Converter<User, UserCommand> {
    @Override
    @Synchronized
    @Nullable
    public UserCommand convert(User source) {
        final UserCommand userCommand = new UserCommand();
        userCommand.setId(source.getId());
        userCommand.setDiscsRented(source.getDiscsRented());
        userCommand.setFirstName(source.getFirstName());
        userCommand.setLastName(source.getLastName());

        return userCommand;
    }
}
