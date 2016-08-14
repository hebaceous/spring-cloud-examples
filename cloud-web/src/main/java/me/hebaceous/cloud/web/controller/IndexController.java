package me.hebaceous.cloud.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;

@RestController
public class IndexController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @RequestMapping(method = RequestMethod.GET)
    Calendar index() {
        return Calendar.getInstance();
    }

}
