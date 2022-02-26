package umb.fpv.ki.demo;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController{

    private List<User> users;

    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/api/users")
    public List<User> getUsers(@RequestParam(required = false) String userFirstName){
        return userService.getUsers(userFirstName);
    }

    @GetMapping("/api/user/{userId}")
    public User getUser(@PathVariable Integer userId){
        return this.userService.getUserId(userId);
    }

    @GetMapping("/api/userId")
    public List<User> getUsersId(@RequestParam(required = false) String userId){
        return this.userService.getUserId(userId);
    }

    @GetMapping("/api/email")
    public List<User> getUserEmail(@RequestParam(required = false) String userEmail){
        return userService.getUserEmail(userEmail);
    }

    @PostMapping("/api/users")
    public List<User> create_User(@RequestBody User user){
      return userService.create_User(user);
    }

    @DeleteMapping("api/users/{userId}")
    public void delete_User(@PathVariable Integer userId) {
        this.userService.delete_User(userId);
    }

    @PutMapping("api/users{userId}")
    public List<User> put_User(@PathVariable Integer userId, @RequestBody User user) {
        return this.userService.put_User(userId, user);
    }


}