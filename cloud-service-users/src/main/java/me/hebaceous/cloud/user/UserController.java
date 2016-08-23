package me.hebaceous.cloud.user;

import me.hebaceous.cloud.api.domain.User;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/")
@RefreshScope
public class UserController implements InitializingBean {

    // mock
    private ConcurrentMap<Long, User> userMap = new ConcurrentHashMap<>();

    @Override
    public void afterPropertiesSet() throws Exception {
        userMap.put(5L, new User().setId(5L).setName("mumu"));
        userMap.put(7L, new User().setId(7L).setName("lele"));
    }

    @GetMapping
    List<User> all() {
        return userMap.entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    User user(@PathVariable Long id) {
        return userMap.get(id);
    }


    @Value("${message}")
    String message;

    @GetMapping("message")
    String message() {
        return message;
    }
}
