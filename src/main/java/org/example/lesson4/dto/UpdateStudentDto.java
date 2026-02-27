package org.example.lesson4.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.lesson4.constant.ValidationConstant;

/**
 * Created by Roman Gulevatiy on 26.02.2026.
 * github github.com/RomanGulevatiy
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateStudentDto {

    @NotBlank(message = ValidationConstant.Student.NAME_REQUIRED_MESSAGE)
    @Size(
            min = ValidationConstant.Student.NAME_MIN,
            max = ValidationConstant.Student.NAME_MAX,
            message = ValidationConstant.Student.NAME_SIZE_MESSAGE
    )
    private String name;

    @NotNull(message = ValidationConstant.Student.AGE_REQUIRED_MESSAGE)
    @Min(
            value = ValidationConstant.Student.AGE_MIN_VALUE,
            message = ValidationConstant.Student.AGE_SIZE_MESSAGE
    )
    private Integer age;

    @NotNull(message = ValidationConstant.Student.COURSE_REQUIRED_MESSAGE)
    @Min(ValidationConstant.Student.COURSE_MIN_VALUE)
    @Max(ValidationConstant.Student.COURSE_MAX_VALUE)
    private Integer course;
}
