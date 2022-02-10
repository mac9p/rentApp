package com.mac9p.rentapp.Services;

import com.mac9p.rentapp.Model.User;
import com.mac9p.rentapp.Repositories.UserRepository;
import com.sun.istack.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findUserById(@NotNull Long id){
        return userRepository.findUserById(id);
    }

    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    public User findUserByLastName(String lastName){
        return userRepository.findUserByLastName(lastName);
    }

    public User addUser(@NotNull User user){
        return userRepository.save(user);
    }

    public void deleteUserById(@NotNull Long id){
        userRepository.deleteById(id);
    }

}
