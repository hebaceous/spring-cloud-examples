package me.hebaceous.cloud.gateway.client.fallback;

import me.hebaceous.cloud.api.domain.Order;
import me.hebaceous.cloud.gateway.client.OrderClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collections;
import java.util.List;

@Component
public class OrderClientFallback implements OrderClient {
    @Override
    public List<Order> all() {
        return Collections.emptyList();
    }

    @Override
    public Order order(@PathVariable("orderId") Long orderId) {
        return new Order();
    }
}
