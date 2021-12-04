package com.example.demo.filters;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class MyPreFilter implements GlobalFilter{
	
	private final Logger logger = LoggerFactory.getLogger(MyPreFilter.class);

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		
		logger.info("My first Pre-filter is executed.....");
		
		String path = exchange.getRequest().getPath().toString();
		logger.info("Request Path = " + path);
		
		HttpHeaders headers = exchange.getRequest().getHeaders();
		
		Set<String> names = headers.keySet();
		
		logger.info("-------------------------------------------------------------");
		names.forEach( (h) -> {
			String value = headers.getFirst(h);
			logger.info(h + " -> " + value);
		});
		logger.info("---------------------------------------------------------------");
		return chain.filter(exchange);
	}

}
