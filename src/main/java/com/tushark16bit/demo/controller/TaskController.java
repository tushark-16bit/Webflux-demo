package com.tushark16bit.demo.controller;

import com.tushark16bit.demo.models.Task;
import com.tushark16bit.demo.models.requests.CreateTaskRequest;
import com.tushark16bit.demo.models.requests.UpdateTaskRequest;
import com.tushark16bit.demo.service.TaskService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

//@RestController
//@RequestMapping("/tasks")
public class TaskController {

    private Logger logger = LoggerFactory.getLogger(TaskController.class);

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

//    @PostMapping
//    public Mono<ResponseEntity<Task>> createTask(@Valid @RequestBody CreateTaskRequest request) {
//        return taskService.createTask(request)
//                .map(ResponseEntity::ok)
//                .doOnError(ex ->
//                        logger.error("error faced: " + ex))
//                .onErrorResume(ex ->
//                        Mono.just(ResponseEntity.badRequest().build()));
//    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Task>> getTask(@PathVariable Long id) {
        return taskService.getTask(id)
                .map(ResponseEntity::ok)
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

//    @GetMapping
//    public Mono<ResponseEntity<Flux<Task>>> getTasks() {
//        var tasks = taskService.findAll();
//        return tasks.hasElements()
//                .map(hasElements ->
//                        hasElements?
//                        ResponseEntity.ok().body(tasks):
//                        ResponseEntity.noContent().build());
//
//    }

    @PutMapping
    public Mono<ResponseEntity<Task>> updateTask(@Valid @RequestBody UpdateTaskRequest request) {
        return taskService.updateTask(request)
                .map(ResponseEntity::ok)
                .onErrorResume(ex -> {
                    if (ex instanceof NoSuchElementException) return Mono.just(ResponseEntity.notFound().build());
                    else return Mono.just(ResponseEntity.badRequest().build());
                });
    }

    @GetMapping("/flux")
    public Flux<Integer> fluxTest() {
//        Flux.interval(Duration.of())
//        Flux.fromStream(Stream.of(1,2,3,4,5,6,7,8,9))
        return null;
    }
}
