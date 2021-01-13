package com.loginexample.springjwt.user.controller;

import com.loginexample.springjwt.user.dto.UserDTO;
import com.loginexample.springjwt.user.dto.UserMessageDTO;
import com.loginexample.springjwt.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserMessageDTO create(@RequestBody UserDTO userDTO){
        return userService.create(userDTO);
    }


    @GetMapping
    public List<UserDTO> findAll(){
        return userService.findAll();
    }
}
