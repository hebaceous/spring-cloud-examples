package me.hebaceous.cloud.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class Config {

    public static void main(String[] args) {
        SpringApplication.run(Config.class, args);
    }

}
