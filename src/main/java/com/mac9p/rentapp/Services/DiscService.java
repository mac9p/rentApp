package com.mac9p.rentapp.Services;

import com.mac9p.rentapp.Model.Disc;
import com.mac9p.rentapp.Model.GenreOfMovie;
import com.mac9p.rentapp.Repositories.DiscRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscService {

    private final DiscRepository discRepository;

    public DiscService(DiscRepository discRepository) {
        this.discRepository = discRepository;
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

    public Disc getDiscByGenre(GenreOfMovie genre){
            return discRepository.findDiscByGenre(genre);
    }

    public Disc findDiscByTitle(String title){
        return discRepository.findDiscByTitle(title);
    }


}
