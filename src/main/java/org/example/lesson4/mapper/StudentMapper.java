package org.example.lesson4.mapper;

import lombok.RequiredArgsConstructor;
import org.example.lesson4.dto.CreateStudentDto;
import org.example.lesson4.dto.StudentResponse;
import org.example.lesson4.dto.UpdateStudentDto;
import org.example.lesson4.model.Student;
import org.springframework.stereotype.Component;

/**
 * Created by Roman Gulevatiy on 26.02.2026.
 * github github.com/gulevatiy-roman
 */
@Component
@RequiredArgsConstructor
public class StudentMapper {

    public StudentResponse toStudentResponse(Student student) {
        if(student == null) return null;

        return StudentResponse
                .builder()
                .id(student.getId())
                .name(student.getName())
                .email(student.getEmail())
                .age(student.getAge())
                .course(student.getCourse())
                .createdAt(student.getCreatedAt())
                .build();
    }

    public Student createStudentFromDto(CreateStudentDto request) {
        if(request == null) return null;

        return Student
                .builder()
                .name(request.getName())
                .email(request.getEmail())
                .age(request.getAge())
                .course(request.getCourse())
                .build();
    }

    public Student updateStudentFromDto(UpdateStudentDto request) {
        if(request == null) return null;

        return Student
                .builder()
                .name(request.getName())
                .age(request.getAge())
                .course(request.getCourse())
                .build();
    }
}
