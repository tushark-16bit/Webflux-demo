package com.tushark16bit.demo;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}


//@Configuration
//class HelloRouter {
//
//	@Bean
//	public RouterFunction<ServerResponse> helloRoute() {
//		return RouterFunctions.route(GET("/hello"),
//				request -> ServerResponse.ok().bodyValue("Hello from WebFlux!"));
//	}
//
//	@Bean
//	public ApplicationRunner validateRoute(RouterFunction<ServerResponse> route) {
//		return args -> System.out.println("✅ RouterFunction bean loaded: " + route);
//	}
//}