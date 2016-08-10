package me.hebaceous.cloud.web.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @Value("${message}")
    private String message;

    @RequestMapping(method = RequestMethod.GET)
    String index() {
        return message;
    }

}
