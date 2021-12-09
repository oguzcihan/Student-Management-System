package com.example.springboot.controllers;

import com.example.springboot.entity.Student;
import com.example.springboot.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    private StudentService _studentService;

    public StudentController(StudentService studentService) {
        _studentService = studentService;
    }

    //handler method to handle list students and return mode and view
    @GetMapping("/students")
    public String listStudents(Model model)
    {
        model.addAttribute("studens",_studentService.getAllStudents());
        return "students";
    }

    @GetMapping("/students/new")
    public String saveStudent(Model model)
    {
        //createStudent object to hold student form data
        Student student=new Student();
        model.addAttribute("student",student);
        return "create-student";
    }

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student)
    {
        _studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students/edit/{id}")
    public String updateStudent(@PathVariable Long id,Model model)
    {
        model.addAttribute("student",_studentService.getStudentById(id));
        return "edit-student";
    }

    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Long id,@ModelAttribute("student") Student student,Model model)
    {
        //get student from database by id
        Student existingStudent=_studentService.getStudentById(id);
        existingStudent.setId(id);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());

        //save updated student object
        _studentService.updateStudent(existingStudent);
        return "redirect:/students";

    }

    @GetMapping("students/{id}")
    public String deleteStudent(@PathVariable Long id)
    {
        _studentService.deleteStudent(id);
        return "redirect:/students";
    }




}
