package me.hebaceous.cloud.order.client;

import me.hebaceous.cloud.api.domain.User;
import me.hebaceous.cloud.order.client.fallback.UserClientFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "${service.user}", path = "${path.user}", fallback = UserClientFallback.class)
public interface UserClient {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    List<User> all();

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    User user(@PathVariable("userId") Long userId);

}
