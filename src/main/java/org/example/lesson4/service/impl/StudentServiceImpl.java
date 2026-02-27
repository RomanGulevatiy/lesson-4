package org.example.lesson4.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.lesson4.dto.CreateStudentDto;
import org.example.lesson4.dto.StudentResponse;
import org.example.lesson4.dto.UpdateStudentDto;
import org.example.lesson4.mapper.StudentMapper;
import org.example.lesson4.model.Student;
import org.example.lesson4.service.StudentService;
import org.example.lesson4.utils.Storage;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Roman Gulevatiy on 26.02.2026.
 * github github.com/gulevatiy-roman
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class StudentServiceImpl implements StudentService {

    private final StudentMapper studentMapper;
    private final Storage storage;

    @Override
    public StudentResponse createStudent(CreateStudentDto request) {
        if(storage.existsByEmail(request.getEmail())) {
            log.info("Email already exists");
            throw new RuntimeException("Email already exists");
        }

        Student student = studentMapper.createStudentFromDto(request);
        Student saved = storage.save(student);
        log.info("Create student request: {}", student);
        return studentMapper.toStudentResponse(saved);
    }

    @Override
    public StudentResponse updateStudent(Long id, UpdateStudentDto request) {
        Student updated = studentMapper.updateStudentFromDto(request);
        Student saved = storage.update(id, updated);
        if(saved == null) return null;

        log.info("Updated student with id={}", id);
        return studentMapper.toStudentResponse(saved);
    }

    @Override
    public boolean deleteStudent(Long id) {
        Student student = storage.findById(id);
        if(student == null) return false;

        log.info("Deleted student with id={}", id);
        return storage.delete(id);
    }

    @Override
    public StudentResponse getStudent(Long id) {
        Student student = storage.findById(id);
        if(student == null) return null;

        log.info("Get student with id={}", id);
        return studentMapper.toStudentResponse(student);
    }

    @Override
    public List<StudentResponse> getAllStudents() {
        return storage.findAll()
                .stream()
                .map(studentMapper::toStudentResponse)
                .toList();
    }
}
