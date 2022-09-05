package com.example.jpastarti.controller;

import com.example.jpastarti.model.Student;
import com.example.jpastarti.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalTime;
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

    @GetMapping("/addstudent")
    public List<Student> addStudent() {
        Student std = new Student();
        std.setBorn(LocalDate.now());
        std.setBornTime(LocalTime.now());
        List<Student> list = studentRepository.findAll();
        std.setName("Autogenerated size=" + list.size());
        studentRepository.save(std);
        return list;
    }

}
