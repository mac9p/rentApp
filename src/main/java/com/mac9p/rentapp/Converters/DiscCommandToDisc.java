package com.mac9p.rentapp.Converters;

import com.mac9p.rentapp.Commands.DiscCommand;
import com.mac9p.rentapp.Model.Disc;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DiscCommandToDisc implements Converter<DiscCommand, Disc> {
    @Override
    public Disc convert(DiscCommand source) {
        final Disc disc = new Disc();
        disc.setId(source.getId());
        disc.setTitle(source.getTitle());
        disc.setGenre(source.getGenre());
        disc.setYearOfPremiere(source.getYearOfPremiere());
        disc.setLent(source.isLent());
        disc.setDescription(source.getDescription());
        return disc;
    }
}
