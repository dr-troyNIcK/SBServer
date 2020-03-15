package online.javalearn.spacelectrician.SpringBootExample.service;

import online.javalearn.spacelectrician.SpringBootExample.model.Role;
import online.javalearn.spacelectrician.SpringBootExample.model.User;
import online.javalearn.spacelectrician.SpringBootExample.repository.RoleRepository;
import online.javalearn.spacelectrician.SpringBootExample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RestServiceImpl implements RestService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public RestServiceImpl(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public User getUser(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public User getUser(long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void saveCryptoUser(User user) {
        Role role = roleRepository.findByRole(user.getRole().getRole());
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRole(role);
        userRepository.save(user);
    }

    @Override
    public void saveUser(User user) {
        Role role = roleRepository.findByRole(user.getRole().getRole());
        user.setRole(role);
        userRepository.save(user);
    }

    @Override
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }
}
