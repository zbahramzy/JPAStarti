package com.example.jpastarti;

import com.example.jpastarti.model.Student;
import com.example.jpastarti.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class JpaStartiApplicationTests {

    @Autowired
    StudentRepository studentRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void testStudent() {
        Student std1 = new Student();
        std1.setBorn(LocalDate.now());
        std1.setName("Kaj");
        studentRepository.save(std1);

        List<Student> list = studentRepository.findAll();
        //assertEquals(3, list.size());
        assertEquals(true, list.size()>10);

        studentRepository.delete(std1);
        list = studentRepository.findAll();
        //assertEquals(2, list.size());

        Optional<Student> opt = studentRepository.findById(1);
        if(opt.isPresent()) {
            Student std3 = opt.get();
            assertEquals(std3.getName(), "Kaj");
        }

    }

}
