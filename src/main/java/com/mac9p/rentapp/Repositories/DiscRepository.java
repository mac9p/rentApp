package com.mac9p.rentapp.Repositories;

import com.mac9p.rentapp.Model.Disc;
import com.mac9p.rentapp.Model.GenreOfMovie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscRepository extends JpaRepository<Disc,Long> {

    Disc findDiscByGenre(GenreOfMovie genre);

    Disc findDiscById(Long id);

    Disc findDiscByTitle(String title);
}
