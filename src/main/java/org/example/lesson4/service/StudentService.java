package org.example.lesson4.service;

import org.example.lesson4.dto.CreateStudentDto;
import org.example.lesson4.dto.StudentResponse;
import org.example.lesson4.dto.UpdateStudentDto;

import java.util.List;

/**
 * Created by Roman Gulevatiy on 26.02.2026.
 * github github.com/RomanGulevatiy
 */
public interface StudentService {

    StudentResponse createStudent(CreateStudentDto request);

    StudentResponse updateStudent(Long id, UpdateStudentDto request);

    boolean deleteStudent(Long id);

    StudentResponse getStudent(Long id);

    List<StudentResponse> getAllStudents();
}
