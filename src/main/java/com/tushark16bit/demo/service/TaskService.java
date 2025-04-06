package com.tushark16bit.demo.service;

import com.tushark16bit.demo.models.Task;
import com.tushark16bit.demo.models.Task.TaskBuilder;
import com.tushark16bit.demo.models.requests.CreateTaskRequest;
import com.tushark16bit.demo.models.requests.UpdateTaskRequest;
import com.tushark16bit.demo.repository.TaskRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@Service
public class TaskService {

    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Mono<Task> createTask(CreateTaskRequest request) {
        return Mono.just(new Task(null, request.getTitle(), request.getDescription(), false, LocalDateTime.now(), LocalDateTime.now().plusDays(7)))
                .flatMap(task -> taskRepository.save(task));
    }

    public Mono<Task> getTask(Long id) {
        return taskRepository.findById(id);
    }

    public Flux<Task> findAll() {
        return taskRepository.findAll();
    }

    public Mono<Task> updateTask(UpdateTaskRequest request) {
        // check if exists with id, if not return exception not found
        // if exists, update, due date should
        return Mono.from(taskRepository.existsById(request.getId()))
                .flatMap(exists -> {
                    if(exists) return taskRepository.findById(request.getId());
                    else throw new NoSuchElementException("Not found");
                })
                .map(task -> {
                    task.setDescription(request.getDescription());
                    task.setTitle(request.getTitle());
                    task.setCompleted(request.isCompleted());
                    task.setDueDate(request.getDueDate());
                    return task;
                })
                .flatMap(task -> taskRepository.save(task));
    }
}
