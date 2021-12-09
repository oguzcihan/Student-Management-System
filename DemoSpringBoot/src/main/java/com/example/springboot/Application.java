package com.example.springboot;

import com.example.springboot.entity.Student;
import com.example.springboot.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    private StudentRepository studentRepository;
    @Override
    public void run(String... args) throws Exception {

//        Student student1=new Student(1L,"Oguz1","Cihan1","1oguzcihan12@gmaikl.com");
//        studentRepository.save(student1);
//
//        Student student2=new Student(2L,"Oguz2","Cihan2","2oguzcihan12@gmaikl.com");
//        studentRepository.save(student2);
//
//        Student student3=new Student(3L,"Oguz3","Cihan3","3oguzcihan12@gmaikl.com");
//        studentRepository.save(student3);

    }
}
