package datarestandjpa.demo.controller;

import datarestandjpa.demo.model.Users;
import datarestandjpa.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    /*

    Load user from postman POST users/load

        http://localhost:8080/users/all

     */

    @Autowired
    private UserRepository userRepository;

//    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @GetMapping(value = "/all")
    public List<Users> findAll() {
        return userRepository.findAll();
    }

    @GetMapping(value = "/{name}")
    public Users findByName(@PathVariable final String name) {
        return userRepository.findByName(name);
    }

    @PostMapping(value = "/load")
    public Users load(@RequestBody final Users users) {
        userRepository.save(users);
        return userRepository.findByName(users.getName());
    }
}
