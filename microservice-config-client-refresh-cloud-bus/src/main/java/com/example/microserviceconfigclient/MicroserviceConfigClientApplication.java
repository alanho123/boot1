package com.example.microserviceconfigclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class MicroserviceConfigClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceConfigClientApplication.class, args);
	}
}

@RestController
@RefreshScope
class ConfigClientController {

    @Value("${boot.version:N/A}")
    private String version;

    @Value("${cloud.version:N/A}")
    private String cloudVersion;

    @Value("${env:N/A}")
    private String env;

    @GetMapping("/version")
    public List<String> getVersion() {
        return Arrays.asList(version, cloudVersion, env);
    }
}
