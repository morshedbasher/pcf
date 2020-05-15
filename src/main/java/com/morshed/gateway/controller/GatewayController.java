package com.morshed.gateway.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GatewayController {

    @RequestMapping("/apifailed")
    public String getURL() {
        return "Service is not available";
    }
}
