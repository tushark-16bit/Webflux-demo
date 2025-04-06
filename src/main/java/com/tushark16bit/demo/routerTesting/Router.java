package com.tushark16bit.demo.routerTesting;

import com.tushark16bit.demo.service.TaskService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class Router {

    @Bean
    public RouterFunction<ServerResponse> route(TaskHandler handler) {
        return RouterFunctions.route()
                .GET("/hello", request ->
                        ServerResponse.ok().bodyValue("Hello, WebFlux!"))
                .GET("/tasks", handler::findAllTasks)
                .POST("/tasks", handler::createTask)
                .build();
    }
}
