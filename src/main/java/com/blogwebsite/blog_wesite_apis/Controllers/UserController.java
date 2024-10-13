package com.blogwebsite.blog_wesite_apis.Controllers;
import com.blogwebsite.blog_wesite_apis.Model.UserModel;
import com.blogwebsite.blog_wesite_apis.Payloads.UserDTO;
import com.blogwebsite.blog_wesite_apis.Services.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userApi")
public class UserController {
    
    @Autowired
    UserServiceImpl service;

    @GetMapping("/home")
    public String home(){
        return "USER API working !";
    }
    
    @GetMapping("/users")
    public List<UserDTO> getAll() {

        return service.getAll();
    }

    @GetMapping("/user/{id}")
    public UserDTO getById (@PathVariable int id) {

        return service.getUserDTO(id);
    }


    @PostMapping("/user")
    public UserDTO createUser(@Valid @RequestBody UserModel user) {

        return service.createUser(user);
    }

    @PutMapping("/user")
    public UserDTO updateUser(@Valid @RequestBody UserModel user) {

        return service.updateUser(user);
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable int id) {

        return service.deleteUser(id);
    }
}
