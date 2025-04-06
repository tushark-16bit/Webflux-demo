package com.tushark16bit.demo.models.requests;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateTaskRequest {

    private Long id;
    @NotNull
    private String title;
    private String description;
    @NotNull
    private boolean completed;
    private LocalDateTime dueDate;
}
