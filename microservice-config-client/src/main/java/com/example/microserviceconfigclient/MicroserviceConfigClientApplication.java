package com.example.microserviceconfigclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class MicroserviceConfigClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceConfigClientApplication.class, args);
	}
}

@RestController
class ConfigClientController {

    @Value("${boot.version}")
    private String version;

    @GetMapping("/version")
    public String getVersion() {
        return this.version;
    }
}
