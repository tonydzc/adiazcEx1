package com.examen.examen.web;

import com.examen.examen.domain.User;
import com.examen.examen.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService service;

    public UserController (UserService service) {
        this.service = service;
    }

    @PostMapping("/register-user/user")
    public ResponseEntity<String> registerUser(@RequestBody User user){
        service.saveUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update-user")
    public ResponseEntity<String> updateUser(@RequestBody User user){
        service.updateUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/find-all")
    public List<User> findAllUsers(){
        return service.findAllUsers();
    }


}
