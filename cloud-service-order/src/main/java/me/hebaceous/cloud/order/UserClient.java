package me.hebaceous.cloud.order;

import me.hebaceous.cloud.domain.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("${service.user}")
public interface UserClient {

    @RequestMapping(value = "/users/{userId}", method = RequestMethod.GET)
    User user(@PathVariable("userId") Long userId);

}
