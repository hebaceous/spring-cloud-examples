package me.hebaceous.cloud.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Web {

    public static void main(String[] args) {
        SpringApplication.run(Web.class, args);
    }

}
