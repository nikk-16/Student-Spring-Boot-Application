package com.example.student.stud;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
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

    public void deleteStudent(Long studentId){
        boolean b = studentRepository.existsById((studentId));
        if(!b) { throw new IllegalStateException("student with Id" + studentId + " doesn't exists"); }
        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email){
        student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException(
                        "student with Id "+ studentId + " does not exists"));
        if(name != null &&
                name.length() > 0 &&
                !Objects.equals(student.getName(), name)) {
            student.setName(name);
        }
        if(email != null &&
                email.length() > 0 &&
                !Objects.equals(student.getEmail(), email)) {
            Optional<student> studentOptional= studentRepository.
                    findstudentByEmail(email);
            if(studentOptional.isPresent()){
                throw new IllegalStateException("email taken");
            }
            student.setEmail(email);
        }
    }

}
