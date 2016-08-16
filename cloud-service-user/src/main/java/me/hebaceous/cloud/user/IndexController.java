package me.hebaceous.cloud.user;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@RefreshScope
public class IndexController {

    @Value("${message}")
    String message;

    @RequestMapping(method = RequestMethod.GET)
    String index() {
        return message;
    }

}
