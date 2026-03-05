package com.example.contra_backend.users.Controller;

import com.example.contra_backend.users.Model.User;
import com.example.contra_backend.users.Services.UserServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dev1/users")
public class UserController {

    public final UserServices userServices;

    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }

    @GetMapping
    public List<User> findAll(){
        return userServices.findAll();
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        return userServices.addUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) {
        userServices.deleteUser(id);
    }
}
