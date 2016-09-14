package me.hebaceous.cloud.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.EnableZipkinServer;

@EnableZipkinServer
@SpringBootApplication
public class Zipkin {

    public static void main(String[] args) {
        SpringApplication.run(Zipkin.class, args);
    }

}
