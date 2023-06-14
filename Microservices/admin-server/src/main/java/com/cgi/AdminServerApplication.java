package com.cgi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import io.netty.resolver.DefaultAddressResolverGroup;
import reactor.netty.http.client.HttpClient;

@SpringBootApplication
@EnableAdminServer
public class AdminServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminServerApplication.class, args);
	}

	/*
	 * @Bean
	 * 
	 * @Primary public WebClient webClient() { HttpClient httpClient =
	 * HttpClient.create().resolver(DefaultAddressResolverGroup.INSTANCE); return
	 * WebClient.builder() .clientConnector(new
	 * ReactorClientHttpConnector(httpClient)) .build(); }
	 */
}
