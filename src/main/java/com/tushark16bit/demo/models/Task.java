package com.tushark16bit.demo.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table("tasks")
public class Task {

    @Id
    private Long id;
    private String title;
    private String description;
    private boolean completed;
    private LocalDateTime createAt;
    private LocalDateTime dueDate;
}
