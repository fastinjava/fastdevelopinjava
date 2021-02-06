package com.fastinjava.service.gateway.web.filters.pre;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fastinjava.service.gateway.base.AbstractBaseFilter;
import com.fastinjava.service.gateway.util.GatewayFilterUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.nio.charset.Charset;


/**
 * 1、打印请求参数
 * 2、修改请求参数，并路由到下个节点
 */
@Slf4j
@Component
public class AssembleFilter extends AbstractBaseFilter {

    @Override
    public Mono<Void> doFilter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        URI uri = request.getURI();
        HttpMethod method = request.getMethod();
        HttpHeaders headers = request.getHeaders();
        if (HttpMethod.POST == method) {
            String type = headers.getContentType().getType();
            if (ObjectUtil.isNotEmpty(type) && MediaType.APPLICATION_JSON_UTF8_VALUE.contains(type)) {
                log.info("uri = {} ,method  = {} , headers = {} ", uri, method.toString(), headers);
                return DataBufferUtils.join(exchange.getRequest().getBody())
                        .flatMap(dataBuffer -> {
                            byte[] bytes = new byte[dataBuffer.readableByteCount()];
                            dataBuffer.read(bytes);
                            String originBody = StrUtil.str(bytes, Charset.defaultCharset());
                            log.info("原始post请求参数, originBody = {} ", originBody);//打印请求参数
                            exchange.getAttributes().put("REQUEST_BODY", originBody);

                            JSONObject jsonObject = JSON.parseObject(originBody);

                            String newBody = JSON.toJSONString(jsonObject);
                            log.info("组装之后的请求参数, newBody = {} ", newBody);
                            return GatewayFilterUtil.resetRequestChainFilter(newBody, exchange, chain);
                        });
            }
        } else if (HttpMethod.GET == method) {
            MultiValueMap<String, String> queryParams = request.getQueryParams();
            log.info("GET请求参数: {} ", queryParams);
        }
        return chain.filter(exchange);
    }

    @Override
    public boolean skipFilter(ServerWebExchange exchange) {
        return false;
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
