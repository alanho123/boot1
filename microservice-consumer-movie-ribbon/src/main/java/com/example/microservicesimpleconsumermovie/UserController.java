package com.example.microservicesimpleconsumermovie;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author <a href="mailto:alanho123@gmail.com">Jason Ho</a>
 */
@RestController
@Slf4j
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id) {
        log.info("### user id - {}", id);
        return restTemplate.getForObject("http://microservice-provider-user/user/" + id, User.class);
    }
}
