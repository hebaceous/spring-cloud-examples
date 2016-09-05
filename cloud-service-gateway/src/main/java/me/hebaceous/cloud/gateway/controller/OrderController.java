package me.hebaceous.cloud.gateway.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import me.hebaceous.cloud.api.domain.Order;
import me.hebaceous.cloud.api.domain.User;
import me.hebaceous.cloud.gateway.client.OrderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("${path.order}")
public class OrderController {

    @Autowired
    private OrderClient orderClient;

    @GetMapping
    @HystrixCommand(fallbackMethod = "allFallback")
    List<Order> all() {
        return orderClient.all();
    }

    private List<Order> allFallback() {
        return Collections.emptyList();
    }

    @GetMapping("/{orderId}")
    @HystrixCommand(fallbackMethod = "orderFallback")
    Order order(@PathVariable Long orderId) {
        return orderClient.order(orderId);
    }

    private Order orderFallback() {
        return new Order();
    }
}
