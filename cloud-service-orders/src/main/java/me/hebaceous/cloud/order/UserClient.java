package me.hebaceous.cloud.order;

import me.hebaceous.cloud.api.domain.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("${service.users}")
interface UserClient {

    @GetMapping("/{userId}")
    User user(@PathVariable("userId") Long userId);

}
