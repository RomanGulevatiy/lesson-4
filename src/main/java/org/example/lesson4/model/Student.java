package org.example.lesson4.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Created by Roman Gulevatiy on 26.02.2026.
 * github github.com/gulevatiy-roman
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {

    private Long id;

    private String name;

    private String email;

    private Integer age;

    private Integer course;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
