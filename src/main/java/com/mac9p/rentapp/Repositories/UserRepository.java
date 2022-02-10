package com.mac9p.rentapp.Repositories;

import com.mac9p.rentapp.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findUserById(Long id);
    User findUserByLastName(String lastName);
}
