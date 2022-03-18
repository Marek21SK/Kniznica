package umb.fpv.ki.demo;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class UserController{

    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/api/customers")
    public List<UserDto> getUsers(@RequestParam(required = false) String userFirstName){
        return userService.getUsers(userFirstName);}

    @GetMapping("/api/customerId")
    public List<UserDto> getUsersId(@RequestParam(required = false) String userID){
        return userService.getUserId(userID);}

    @PostMapping("/api/customers")
    public String create_User(@RequestBody UserDto user){
      return userService.create_User(user);
    }

    @DeleteMapping("api/customers/{customerId}")
    public void delete_User(@PathVariable int userId) {
        userService.delete_User(userId);
    }

    @PutMapping("api/customers{customerId}")
    public void put_User(@PathVariable int userId, @RequestBody UserDto user){
        userService.put_User(userId, user);
    }
}