package com.example.microservicesimpleconsumermovie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author <a href="mailto:alanho123@gmail.com">Jason Ho</a>
 */
@RestController
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id) {
        return restTemplate.getForObject("http://172.20.10.3:8000/user/" + id, User.class);
    }
}
