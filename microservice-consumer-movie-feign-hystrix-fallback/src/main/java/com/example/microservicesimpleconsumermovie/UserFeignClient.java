package com.example.microservicesimpleconsumermovie;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author <a href="mailto:alanho123@gmail.com">Jason Ho</a>
 */
@FeignClient(name = "microservice-provider-user", fallback = UserFeignClient.FeignClientFallback.class)
public interface UserFeignClient {

    @GetMapping("/user/{id}")
    User findById(@PathVariable("id") Long id);

    @Component
    class FeignClientFallback implements UserFeignClient {
        @Override
        public User findById(Long id) {
            return new User();
        }
    }
}


