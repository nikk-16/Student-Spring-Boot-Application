package com.example.student.stud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/student")
public class studentController {

    private final studentService studentService;

    @Autowired
    public studentController(com.example.student.stud.studentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping()
    public List<student> getStudent() {
        return studentService.getStudent();
    }
    @PostMapping
    public void resisterNewStudent(@RequestBody student student){
        studentService.addNewStudent(student);
    }

}
