package com.example.web0911.services;

import com.example.web0911.data.Student;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Getter
public class StudentService {
    private final List<Student> students = new ArrayList<>();

    @PostConstruct
    public void init() {
        students.add(new Student("Jack", 20));
        students.add(new Student("Jane", 21));
        students.add(new Student("Kate", 19));
        students.add(new Student("Mike", 22));
    }

    public void add(Student student) {
        students.add(student);
    }

}
