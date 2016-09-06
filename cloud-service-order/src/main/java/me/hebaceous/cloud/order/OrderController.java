package me.hebaceous.cloud.order;

import me.hebaceous.cloud.api.domain.Order;
import me.hebaceous.cloud.order.client.UserClient;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

@RestController
@RequestMapping("${path.order}")
public class OrderController implements InitializingBean {

    // mock
    private ConcurrentMap<Long, Order> orderMap = new ConcurrentHashMap<>();

    @Autowired
    private UserClient userClient;

    @Override
    public void afterPropertiesSet() throws Exception {
        orderMap.put(5L, new Order().setId(5L).setUserId(5L).setDate(new Date()));
        orderMap.put(7L, new Order().setId(7L).setUserId(7L).setDate(new Date()));
    }

    @GetMapping
    List<Order> all() {
        return orderMap.entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .peek(order -> order.setUser(userClient.user(order.getUserId())))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    Order order(@PathVariable Long id) {
        Order order = orderMap.get(id);
        return order.setUser(userClient.user(order.getUserId()));
    }

}
