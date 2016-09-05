package me.hebaceous.cloud.gateway.client;

import me.hebaceous.cloud.api.domain.Order;
import me.hebaceous.cloud.gateway.client.fallback.OrderClientFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "${service.order}", path = "${path.order}", fallback = OrderClientFallback.class)
public interface OrderClient {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    List<Order> all();

    @RequestMapping(value = "/{orderId}", method = RequestMethod.GET)
    Order order(@PathVariable("orderId") Long orderId);

}
