package com.morshed.gateway.controller;

;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class GatewayController {

    @RequestMapping("/api/apifailed")
    public Mono<String> apiFailed() {
        return Mono.just("Api is currently down");
    }
}
