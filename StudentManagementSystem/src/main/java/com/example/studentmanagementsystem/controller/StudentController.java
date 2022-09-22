package com.example.studentmanagementsystem.controller;

import com.example.studentmanagementsystem.model.Student;
import com.example.studentmanagementsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public String listStudent(Model model){
        model.addAttribute("students" ,studentService.getAllStudents());
        return "students";
    }

    @GetMapping("/student/new")
    public String createStudentForm(Model model){
        Student student = new Student();
        model.addAttribute("Student", student);
        return "create-student";
    }

    @PostMapping("/student/edit")
    public String editStudentForm(@PathVariable Long id, Model model){
        model.addAttribute("student", studentService.getStudentById(id));
        return "edit_student";
    }




}
