package me.hebaceous.cloud.user;

import me.hebaceous.cloud.domain.User;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
@SpringCloudApplication
public class UserApp implements InitializingBean {

    // mock
    private ConcurrentMap<Long, User> userMap = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        SpringApplication.run(UserApp.class, args);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        userMap.put(5L, new User().setId(5L).setName("mumu"));
        userMap.put(7L, new User().setId(7L).setName("lele"));
    }

    @RequestMapping(method = RequestMethod.GET)
    List<User> all() {
        return userMap.entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    User user(@PathVariable Long id) {
        return userMap.get(id);
    }

}
