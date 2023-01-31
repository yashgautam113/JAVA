package com.example.demo.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

//    injecting repository
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
//        return List.of(
//                Student.builder().name("arun").email("dasnjdknaksdjnas.com").build(),
//                new Student(
//                        1L,
//                        "Yash",
//                        LocalDate.of(2000, Month.JANUARY,5),
//                        "yash@gmail.com",
//                        22
//                )
//        );
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student){
        System.out.println(student);
        Optional<Student> studentOptional = studentRepository.findStudentsByEmail(student.getEmail());
        if(studentOptional.isPresent()){
            throw new IllegalStateException("email Taken");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if(!exists){
            throw new IllegalStateException(
                    "student with id " + studentId + " does not exists"
            );
        }
        else{
            studentRepository.deleteById(studentId);
        }
    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException(
                        "student with id " + studentId + " does not exist"
                ));

                if(name !=null && name.length()>0 &&
                    !Objects.equals(student.getName(),name)) {
                    student.setName(name);
                }

                if(email!= null && email.length() > 0 &&
                    !Objects.equals(student.getEmail(),email)){
                    Optional<Student> studentOptional = studentRepository
                            .findStudentsByEmail(email);
                    if(studentOptional.isPresent()){
                        throw new IllegalStateException("email taken");
                    }
                    student.setEmail(email);
        }
    }
}
