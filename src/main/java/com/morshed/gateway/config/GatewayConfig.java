package com.morshed.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableHystrix
@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p
                        .path("/api/get")
                        .filters(f -> f.addRequestHeader("Hello", "World"))
                        .uri("http://httpbin.org:80"))
                .route(P -> P
                        .path("/api/users")
                        .filters(f -> f.hystrix(config -> config.setName("api-test")
                                        .setFallbackUri("forward:/api/apifailed")))
                        .uri("https://reqres.in/"))
                .route(em -> em
                        .path("/api/v1/employees")
                        .filters(emf -> emf.hystrix(config -> config.setName("employee-api")))
                        .uri("http://dummy.restapiexample.com/"))
                .route(p -> p
                        .host("*.hystrix.com")
                        .filters(f -> f.hystrix(config -> config.setName("mycmd")))
                        .uri("http://httpbin.org:80"))
                .build();
    }
}
