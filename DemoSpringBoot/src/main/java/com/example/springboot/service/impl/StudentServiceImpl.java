package com.example.springboot.service.impl;

import com.example.springboot.entity.Student;
import com.example.springboot.repository.StudentRepository;
import com.example.springboot.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository _studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        _studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return _studentRepository.findAll();
    }

    @Override
    public Student saveStudent(Student student) {


        return _studentRepository.save(student);
    }

    @Override
    public Student getStudentById(Long id) {
        return _studentRepository.findById(id).get();
    }

    @Override
    public Student updateStudent(Student student) {
        return _studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        _studentRepository.deleteById(id);
    }
}
