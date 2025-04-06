package com.tushark16bit.demo.repository;

import com.tushark16bit.demo.models.Task;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface TaskRepository extends R2dbcRepository<Task, Long> {
}
