package com.example.feignhystrix;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableCircuitBreaker
public class FeignHystrixApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeignHystrixApplication.class, args);
	}
}

@RestController
@Slf4j
class UserController {
    @Autowired
    private FeignClientUser feignClientUser;

    @GetMapping("/user/{id}")
    public User findById(@PathVariable("id") Long id) {
        return feignClientUser.findById(id);
    }
}

@FeignClient(name="microservice-provider-user", fallback = FeignClientUserFallback.class)
interface FeignClientUser {
    @GetMapping("/user/{id}")
    User findById(@PathVariable("id") Long id);
}

@Component
class FeignClientUserFallback implements FeignClientUser {
    @Override
    public User findById(Long id) {
        return new User();
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class User {
    private Long id;
    private String account;
    private String username;
    private BigDecimal balance;
    private Integer age;
}