package me.hebaceous.cloud.gateway.controller;

import me.hebaceous.cloud.api.domain.Order;
import me.hebaceous.cloud.gateway.client.OrderClient;
import me.hebaceous.cloud.gateway.client.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("${path.order}")
public class OrderController {

    @Autowired
    private OrderClient orderClient;

    @Autowired
    private UserClient userClient;

    @GetMapping
    List<Order> all() {
        return orderClient.all();
    }

    @GetMapping("/{orderId}")
    Order order(@PathVariable Long orderId) {
        return orderClient.order(orderId);
    }

}
