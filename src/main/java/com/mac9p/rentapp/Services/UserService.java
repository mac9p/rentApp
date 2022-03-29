package com.mac9p.rentapp.Services;

import com.mac9p.rentapp.Commands.UserCommand;
import com.mac9p.rentapp.Converters.UserCommandToUser;
import com.mac9p.rentapp.Converters.UserToUserCommand;
import com.mac9p.rentapp.Model.User;
import com.mac9p.rentapp.Repositories.UserRepository;
import com.sun.istack.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserToUserCommand userToUserCommand;
    private final UserCommandToUser userCommandToUser;

    public UserService(UserRepository userRepository,
                       UserToUserCommand userToUserCommand,
                       UserCommandToUser userCommandToUser) {
        this.userRepository = userRepository;
        this.userToUserCommand = userToUserCommand;
        this.userCommandToUser = userCommandToUser;
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

    public UserCommand saveUserCommand(@NotNull UserCommand userCommand){
        User detachedUser = userCommandToUser.convert(userCommand);
        User savedUser = userRepository.save(detachedUser);

        log.debug("Saved User id: "+ savedUser.getId());
        return userToUserCommand.convert(savedUser);
    }

}
