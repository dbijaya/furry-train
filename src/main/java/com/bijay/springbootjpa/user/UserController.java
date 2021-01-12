package com.bijay.springbootjpa.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
public class UserController {
    
    @Autowired
    private UserService userService;

    @RequestMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @RequestMapping("/users/{id}")
    public Optional<User> getUser(@PathVariable Integer id) {
        return userService.getUser(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/users")
    public String addUser(@RequestBody User user) {
        userService.addUser(user);
        return String.format("User: '%s' - added successfully.", user.getName());
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/users/{id}")
    public String updateUser(@RequestBody User user, @PathVariable Integer id){
        userService.updateUser(user, id);
        return String.format("User: '%s' - updated successfully.", user.getName());
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/users/{id}")
    public String userDelete(@PathVariable Integer id){
        userService.deleteUser(id);
        return String.format("User of id: '%d' - deleted.", id);
    }

}
