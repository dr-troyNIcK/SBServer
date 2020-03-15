package online.javalearn.spacelectrician.SpringBootExample.controller;

import online.javalearn.spacelectrician.SpringBootExample.model.Role;
import online.javalearn.spacelectrician.SpringBootExample.model.User;
import online.javalearn.spacelectrician.SpringBootExample.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RESTController {

    private RestService restService;

    @Autowired
    public RESTController(RestService restService) {
        this.restService = restService;
    }

    @GetMapping("/user/{name}")
    public User userById(@PathVariable String name) {
        return restService.getUser(name);
    }

    @GetMapping("/admin/user/{id}")
    public User userById(@PathVariable Long id) {
        return restService.getUser(id);
    }

    @GetMapping("/admin/roles")
    public List<Role> roles() {
        return restService.getAllRoles();
    }

    @GetMapping("/admin/users")
    public List<User> users() {
        return restService.getAllUsers();
    }

    @PostMapping("/admin/save_crypto_user")
    public void saveCryptoUser(@RequestBody User user) {
        restService.saveCryptoUser(user);
    }

    @PostMapping("/admin/save_user")
    public void saveUser(@RequestBody User user) {
        restService.saveUser(user);
    }

    @DeleteMapping("/admin/delete_user/{id}")
    public void deleteUser(@PathVariable Long id) {
        restService.deleteUser(id);
    }

}
