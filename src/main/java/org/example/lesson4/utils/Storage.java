package org.example.lesson4.utils;

import org.example.lesson4.model.Student;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Roman Gulevatiy on 26.02.2026.
 * github github.com/RomanGulevatiy
 */
@Component
public class Storage {

    private final Map<Long, Student> students = new HashMap<>();
    private Long idCounter = 1L;

    public Student save(Student student) {
        if(student.getId() == null) {
            student.setId(idCounter);
            student.setCreatedAt(LocalDateTime.now());
            idCounter++;
        }

        student.setUpdatedAt(LocalDateTime.now());
        students.put(student.getId(), student);
        return student;
    }

    public Student update(Long id, Student updatedData) {
        Student existing = students.get(id);
        if(existing == null) return null;

        existing.setName(updatedData.getName());
        existing.setAge(updatedData.getAge());
        existing.setCourse(updatedData.getCourse());
        existing.setUpdatedAt(java.time.LocalDateTime.now());

        return existing;
    }

    public boolean delete(Long id) {
        students.remove(id);
        return true;
    }

    public Student findById(Long id) {
        return students.get(id);
    }

    public List<Student> findAll() {
        return new ArrayList<>(students.values());
    }

    public boolean existsByEmail(String email) {
        return students.values()
                .stream()
                .anyMatch(student -> student.getEmail().equals(email));
    }
}
