package me.hebaceous.cloud.order;

import me.hebaceous.cloud.domain.Order;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orders")
@SpringCloudApplication
@EnableFeignClients
public class OrderApp implements InitializingBean {

    // mock
    private ConcurrentMap<Long, Order> orderMap = new ConcurrentHashMap<>();

    @Autowired
    private UserClient userClient;

    public static void main(String[] args) {
        SpringApplication.run(OrderApp.class, args);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        orderMap.put(5L, new Order().setId(5L).setUserId(5L).setDate(new Date()));
        orderMap.put(7L, new Order().setId(7L).setUserId(7L).setDate(new Date()));
    }

    @RequestMapping(method = RequestMethod.GET)
    List<Order> all() {
        return orderMap.entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    Order user(@PathVariable Long id) {
        Order order = orderMap.get(id);
        order.setUser(userClient.user(order.getUserId()));
        return order;
    }

}
