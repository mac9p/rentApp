package com.mac9p.rentapp.Converters;

import com.mac9p.rentapp.Commands.DiscCommand;
import com.mac9p.rentapp.Model.Disc;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DiscToDiscCommand implements Converter<Disc, DiscCommand> {
    @Override
    public DiscCommand convert(Disc source) {
        final DiscCommand discCommand = new DiscCommand();
        discCommand.setId(source.getId());
        discCommand.setTitle(source.getTitle());
        discCommand.setGenre(source.getGenre());
        discCommand.setPrice(source.getPrice());
        discCommand.setYearOfPremiere(source.getYearOfPremiere());
        discCommand.setLent(source.isLent());
        discCommand.setDescription(source.getDescription());
        discCommand.setUserRenting(source.getUserRenting());
        return discCommand;
    }
}
