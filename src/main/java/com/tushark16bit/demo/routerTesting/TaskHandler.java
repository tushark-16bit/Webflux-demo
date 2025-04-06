package com.tushark16bit.demo.routerTesting;

import com.tushark16bit.demo.models.Task;
import com.tushark16bit.demo.models.requests.CreateTaskRequest;
import com.tushark16bit.demo.service.TaskService;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class TaskHandler {

    private TaskService taskService;

    public TaskHandler(TaskService taskService) {
        this.taskService = taskService;
    }

    public Mono<ServerResponse> findAllTasks(ServerRequest request) {
        return ServerResponse.ok().body(taskService.findAll(), Task.class);
    }

    public Mono<ServerResponse> createTask(ServerRequest request) {
        return request.bodyToMono(CreateTaskRequest.class)
                .flatMap(createRequest -> taskService.createTask(createRequest))
                .flatMap(response -> ServerResponse.ok().bodyValue(response))
                .onErrorResume(ex -> ServerResponse.badRequest().build());
    }
}
