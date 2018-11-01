package com.example.microservicesimpleconsumermovie;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author <a href="mailto:alanho123@gmail.com">Jason Ho</a>
 */
@FeignClient(name = "microservice-provider-user")
public interface UserFeignClient {

    @GetMapping("/user/{id}")
    User findById(@PathVariable("id") Long id);

}
