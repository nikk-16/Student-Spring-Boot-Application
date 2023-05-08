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

    @GetMapping
    public List<student> getStudent() {
        return studentService.getStudent();
    }
    @PostMapping
    public void resisterNewStudent(@RequestBody student student){
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId){
        studentService.deleteStudent(studentId);
    }

    @PutMapping("{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email){
        studentService.updateStudent(studentId, name, email);
    }

}
