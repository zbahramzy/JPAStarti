package com.example.jpastarti.controller;

import com.example.jpastarti.model.Student;
import com.example.jpastarti.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentRestController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/students")
    public List<Student> students() {
        List<Student> list = studentRepository.findAll();
        return list;
    }

}
