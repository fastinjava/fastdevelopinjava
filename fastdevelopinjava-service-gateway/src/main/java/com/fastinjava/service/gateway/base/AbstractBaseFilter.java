package com.fastinjava.service.gateway.base;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Slf4j
public abstract class AbstractBaseFilter implements Ordered, GlobalFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        if (skipFilter(exchange)) {
            return chain.filter(exchange);
        }
        return doFilter(exchange, chain);
    }

    public abstract Mono<Void> doFilter(ServerWebExchange exchange, GatewayFilterChain chain);


    public abstract boolean skipFilter(ServerWebExchange exchange);


}
