package com.dhcc.zpc.gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description TODO
 * @Author 赵朋超
 * @Date 2020/5/29 17:33
 * @Version 1.0
 */
@Configuration
public class GatewayRoutes {

    @Bean(name = "risk")
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r ->
                        r.path("/risk/**")
                                .filters( f -> f.stripPrefix(1))
                                .uri("http://localhost:8083/")
                                .order(0)
                                .id("risk")
                ).build();
    }
    @Bean(name = "risk-test")
    public RouteLocator routeLocatorTest(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r ->
                        r.path("/api/**")
                                .filters( f -> f.stripPrefix(1))
                                .uri("http://localhost:8080/")
                                .order(1)
                                .id("risk-test")
                ).build();
    }
}
