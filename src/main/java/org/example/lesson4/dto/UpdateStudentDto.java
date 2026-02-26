package org.example.lesson4.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Roman Gulevatiy on 26.02.2026.
 * github github.com/gulevatiy-roman
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateStudentDto {

    private String name;

    private Integer age;

    private Integer course;
}
