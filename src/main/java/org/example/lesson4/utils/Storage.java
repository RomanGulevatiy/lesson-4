package org.example.lesson4.utils;

import org.example.lesson4.model.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Roman Gulevatiy on 26.02.2026.
 * github github.com/gulevatiy-roman
 */
@Component
public class Storage {

    private final Map<Long, Student> students = new HashMap<>();
    private Long idCounter = 1L;

    public Student save(Student student) {
        if(student.getId() == null) {
            student.setId(idCounter);
            idCounter++;
        }

        students.put(student.getId(), student);
        return student;
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
}
