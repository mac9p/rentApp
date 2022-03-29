package com.mac9p.rentapp.Services;

import com.mac9p.rentapp.Commands.DiscCommand;
import com.mac9p.rentapp.Converters.DiscCommandToDisc;
import com.mac9p.rentapp.Converters.DiscToDiscCommand;
import com.mac9p.rentapp.Model.Disc;
import com.mac9p.rentapp.Model.GenreOfMovie;
import com.mac9p.rentapp.Repositories.DiscRepository;
import com.sun.istack.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DiscService {

    private final DiscRepository discRepository;
    private final DiscToDiscCommand discToDiscCommand;
    private final DiscCommandToDisc discCommandToDisc;

    public DiscService(DiscRepository discRepository, DiscToDiscCommand discToDiscCommand, DiscCommandToDisc discCommandToDisc) {
        this.discRepository = discRepository;
        this.discToDiscCommand = discToDiscCommand;
        this.discCommandToDisc = discCommandToDisc;
    }

    public Disc addDisc(Disc disc) {
        if (disc != null)
            return discRepository.save(disc);
        else
            return null;
    }

    public void deleteDiscById(Long id){
        discRepository.deleteById(id);
    }

    public List<Disc> getAllDiscs(){
        return discRepository.findAll();
    }

    public Disc getDiscById(Long id){
        return discRepository.findDiscById(id);
    }

    public List<Disc> getDiscsByGenre(GenreOfMovie genre){
            return discRepository.findDiscsByGenre(genre);
    }

    public Disc findDiscByTitle(String title){
        return discRepository.findDiscByTitle(title);
    }

    public DiscCommand saveDiscCommand(@NotNull DiscCommand command){
        Disc detachedDisc = discCommandToDisc.convert(command);

        Disc savedDisc = discRepository.save(detachedDisc);

        log.debug("Saved disc id: "+ savedDisc.getId());
        return discToDiscCommand.convert(savedDisc);
    }

}
