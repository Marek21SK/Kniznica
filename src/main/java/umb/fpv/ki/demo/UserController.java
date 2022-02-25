package umb.fpv.ki.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    List<User> users;

    public UserController() {
        this.users = init();
    }

    public List<User> init() {
        List<User> users = new ArrayList<>();

        User User_1 = new User();
        User_1.setFirstName("Andrej");
        User_1.setLastName("Sapkowski");
        User_1.setEmail("andrejwitchersapkowski@gmail.pl");
        User_1.setId("1");
        users.add(User_1);

        User User_2 = new User();
        User_2.setFirstName("George Raymond Richard");
        User_2.setLastName("Martin");
        User_2.setEmail("georgerrgotmartin@gmail.com");
        User_2.setId("2");
        users.add(User_2);

        User User_3 = new User();
        User_3.setFirstName("Kass");
        User_3.setLastName("Morgan");
        User_3.setEmail("kassthe100morgan@gmail.com");
        User_3.setId("3");
        users.add(User_3);

        return users;
    }


    @GetMapping("/api/users")
    public List<User> getUsers(@RequestParam(required = false) String userFirstName) {
        if (userFirstName == null) {
            return this.users;
        }

        List<User> f_Users = new ArrayList<>();
        for (User user : users) {
            if (user.getFirstName().equals(userFirstName)) {
                f_Users.add(user);
            }
        }
        return f_Users;
    }


    @GetMapping("/api/userId")
    public List<User> getUsersId(@RequestParam(required = false) String userId) {
        if (userId == null) {
            return this.users;
        }

        List<User> f_Users = new ArrayList<>();
        for (User user : users) {
            if (user.getId().equals(userId)) {
                f_Users.add(user);
            }
        }
        return f_Users;

    }


    @PostMapping("/api/users")
    public List<User> create_User(@RequestBody User user) {
        this.users.add(user);
        return users;
    }

    @DeleteMapping("api/users/{userId}")
    public void delete_User(@PathVariable Integer userId) {
        this.users.remove(this.users.get(userId));
    }

    @PutMapping("api/users{userId}")
    public List<User> put_User(@PathVariable Integer userId, @RequestBody User user) {
        this.users.get(userId).setFirstName(user.getFirstName());
        this.users.get(userId).setLastName(user.getLastName());
        this.users.get(userId).setEmail(user.getEmail());
        this.users.get(userId).setId(user.getId());
        return users;
    }
}
