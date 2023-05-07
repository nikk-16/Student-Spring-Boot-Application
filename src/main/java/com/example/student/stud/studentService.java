package com.example.student.stud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class studentService {
    private final studentRepository studentRepository;

    public studentService(com.example.student.stud.studentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<student> getStudent() {
//        return List.of(
//                new Student(
//                        1L,
//                        "Nikhil",
//                        "nikhil@gmail.com",
//                        LocalDate.of(2001, Month.APRIL, 16),
//                        22
//
//                ));
        return studentRepository.findAll();
    }

    public void addNewStudent(student student) {
        Optional<student> studentOptional= studentRepository.
                findstudentByEmail(student.getEmail());
        if(studentOptional.isPresent()){
            throw new IllegalStateException("email taken");
        }
        studentRepository.save(student);
    }
}
