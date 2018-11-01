package com.example.microservicesimpleprovideruser;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

/**
 * @author <a href="mailto:alanho123@gmail.com">Jason Ho</a>
 */
@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id) {
        log.info("##### user id - {}", id);
        return this.userRepository.findOne(id);
    }

    @GetMapping("/user/all")
    public List<User> findAll() {
        return this.userRepository.findAll();
    }

}
