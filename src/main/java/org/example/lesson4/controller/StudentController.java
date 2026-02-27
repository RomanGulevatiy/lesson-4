package org.example.lesson4.controller;

import lombok.RequiredArgsConstructor;
import org.example.lesson4.dto.CreateStudentDto;
import org.example.lesson4.dto.StudentResponse;
import org.example.lesson4.dto.UpdateStudentDto;
import org.example.lesson4.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Roman Gulevatiy on 27.02.2026.
 * github github.com/gulevatiy-roman
 */
@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public StudentResponse createStudent(@RequestBody CreateStudentDto request) {
        return studentService.createStudent(request);
    }

    @PutMapping("/{id}")
    public StudentResponse updateStudent(@PathVariable Long id,
                                         @RequestBody UpdateStudentDto request) {
        return studentService.updateStudent(id, request);
    }

    @DeleteMapping("/{id}")
    public boolean deleteStudent(@PathVariable Long id) {
        return studentService.deleteStudent(id);
    }

    @GetMapping("/{id}")
    public StudentResponse getStudent(@PathVariable Long id) {
        return studentService.getStudent(id);
    }

    @GetMapping
    public List<StudentResponse> getAllStudents() {
        return studentService.getAllStudents();
    }
}
