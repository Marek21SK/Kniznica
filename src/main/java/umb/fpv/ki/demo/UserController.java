package umb.fpv.ki.demo;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class UserController{

    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/api/customers")
    public Long create_User(@RequestBody UserDto user){
        return userService.create_User(user);
    }

    @GetMapping("/api/customers")
    public List<UserDto> getUsers(@RequestParam(required = false) String userFirstName){
        return userService.getUsers(userFirstName);}

    @GetMapping("/api/customerId")
    public UserDto getUsersId(@PathVariable int userID){
        return userService.getUserId(userID);
    }

    @PutMapping("api/customers{customerId}")
    public void put_User(@PathVariable int userId, @RequestBody UserDto user){
        userService.put_User(userId, user);
    }

    @DeleteMapping("api/customers/{customerId}")
    public void delete_User(@PathVariable int userId) {
        userService.delete_User(userId);
    }
}