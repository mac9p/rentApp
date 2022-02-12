package com.mac9p.rentapp.Controllers;

import com.mac9p.rentapp.Model.User;
import com.mac9p.rentapp.Services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/management/users")
public class UserManagmentController {
    private final UserService userService;

    public UserManagmentController(UserService userService) {
        this.userService = userService;

        userService.addUser(new User(new ArrayList<>(),"Jan","Kowalski"));
        userService.addUser(new User(new ArrayList<>(),"Marzena","Kwasniewska"));

    }

    @GetMapping("/all")
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

    @PostMapping
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @DeleteMapping
    public void deleteUserById(@RequestParam Long id){
        userService.deleteUserById(id);
    }


}
