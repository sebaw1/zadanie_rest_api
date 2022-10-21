package pl.sebastian.zadanie.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers(){
        return userService.getAllUsers();
    }

    @PostMapping
    public void addUser(@RequestBody User user){
        userService.addUpdateUser(user);
    }

    @PutMapping("{userId}")
    public void updateUser(@PathVariable("userId") Long userId,
                           @RequestBody User user)
    {
        userService.updateUser(userId, user);
    }

    @DeleteMapping("{userId}")
    public void deleteUser(@PathVariable("userId") Long userId){
         userService.deleteUserById(userId);
    }
}
