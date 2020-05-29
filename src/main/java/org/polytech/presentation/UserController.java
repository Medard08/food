package org.polytech.presentation;

import org.polytech.buisness.User;
import org.polytech.buisness.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/hello")
    public  String hello(@RequestParam("name") String name){
        return "hello world" + name;
    }

    @PostMapping("/user")
    public String insertUser(@RequestBody User user){
        this.userService.createUser(user);
        return "inséré";
    }
}
