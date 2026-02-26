package org.example.lesson4.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.lesson4.dto.CreateStudentDto;
import org.example.lesson4.dto.StudentResponse;
import org.example.lesson4.dto.UpdateStudentDto;
import org.example.lesson4.mapper.StudentMapper;
import org.example.lesson4.model.Student;
import org.example.lesson4.service.StudentService;
import org.example.lesson4.utils.Storage;

/**
 * Created by Roman Gulevatiy on 26.02.2026.
 * github github.com/gulevatiy-roman
 */
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentMapper studentMapper;
    private final Storage storage;

    @Override
    public StudentResponse createStudent(CreateStudentDto request) {
        Student student = studentMapper.createStudentFromDto(request);
        Student saved = storage.save(student);
        return studentMapper.toStudentResponse(saved);
    }

    @Override
    public StudentResponse updateStudent(Long id, UpdateStudentDto request) {
        Student student = storage.findById(id);

        student.setName(request.getName());
        student.setAge(request.getAge());
        student.setCourse(request.getCourse());

        storage.save(student);
        return studentMapper.toStudentResponse(student);
    }

    @Override
    public boolean deleteStudent(Long id) {


        storage.delete(id);
        ma
        return true;
    }

    @Override
    public StudentResponse getStudent(Long id) {
        return null;
    }

    @Override
    public StudentResponse getAllStudents() {
        return null;
    }
}
