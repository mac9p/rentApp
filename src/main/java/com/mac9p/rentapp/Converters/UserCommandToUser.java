package com.mac9p.rentapp.Converters;

import com.mac9p.rentapp.Commands.UserCommand;
import com.mac9p.rentapp.Model.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserCommandToUser implements Converter<UserCommand, User> {
    @Override
    public User convert(UserCommand source) {
        final User user = new User();
        user.setId(source.getId());
        user.setDiscsRented(source.getDiscsRented());
        user.setFirstName(source.getFirstName());
        user.setLastName(source.getLastName());

        return user;
    }
}
