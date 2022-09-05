package com.example.jpastarti.config;

import com.example.jpastarti.model.Student;
import com.example.jpastarti.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class StartAndSave implements CommandLineRunner {

    @Autowired
    StudentRepository studentRepository;

    public StartAndSave(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Student std1 = new Student();
        std1.setBorn(LocalDate.now());
        std1.setName("Kaj");
        studentRepository.save(std1);

        Student std2 = new Student();
        std2.setBorn(LocalDate.now().plusDays(1000));
        std2.setName("Hauv");
        studentRepository.save(std2);

    }
}
