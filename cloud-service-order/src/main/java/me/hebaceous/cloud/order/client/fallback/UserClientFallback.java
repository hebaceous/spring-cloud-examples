package me.hebaceous.cloud.order.client.fallback;

import me.hebaceous.cloud.api.domain.User;
import me.hebaceous.cloud.order.client.UserClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collections;
import java.util.List;

@Component
public class UserClientFallback implements UserClient {
    @Override
    public List<User> all() {
        return Collections.emptyList();
    }
    @Override
    public User user(@PathVariable("userId") Long userId) {
        return new User();
    }
}