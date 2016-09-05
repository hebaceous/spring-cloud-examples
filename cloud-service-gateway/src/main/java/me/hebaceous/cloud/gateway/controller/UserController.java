package me.hebaceous.cloud.gateway.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import me.hebaceous.cloud.api.domain.User;
import me.hebaceous.cloud.gateway.client.OrderClient;
import me.hebaceous.cloud.gateway.client.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("${path.user}")
public class UserController {

    @Autowired
    private UserClient userClient;

    @Autowired
    private OrderClient orderClient;

    @GetMapping
    @HystrixCommand(fallbackMethod = "allFallback")
    List<User> all() {
        return userClient.all();
    }

    private List<User> allFallback() {
        return Collections.emptyList();
    }

    @GetMapping("/{userId}")
    User user(@PathVariable Long userId) {
        return userClient.user(userId);
    }

}
