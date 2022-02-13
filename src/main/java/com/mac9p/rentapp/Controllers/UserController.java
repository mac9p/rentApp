package com.mac9p.rentapp.Controllers;

import com.mac9p.rentapp.Model.User;
import com.mac9p.rentapp.Services.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;

        userService.addUser(new User(new ArrayList<>(),"Jan","Kowalski"));
        userService.addUser(new User(new ArrayList<>(),"Marzena","Kwasniewska"));
    }

    @GetMapping("/all")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_ADMINTRAINEE')")
    public List<User> getAllUsers(){
        return userService.findAllUsers();
    }

    @GetMapping("/id")
    public User getUserById(@RequestParam Long id){
        return userService.findUserById(id);
    }
    @GetMapping("/name")
    public User getUserByLastName(@RequestParam String lastName){
        return userService.findUserByLastName(lastName);
    }

    @PostMapping("/add")
    @PreAuthorize("hasAuthority('user:write')")
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @DeleteMapping("/delete")
    @PreAuthorize("hasAuthority('user:write')")
    public void deleteUserById(@RequestParam Long id){
        userService.deleteUserById(id);
    }


}
