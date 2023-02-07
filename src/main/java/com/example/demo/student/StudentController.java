package com.example.demo.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private StudentService studentService;
//     @Autowired
//     StudentService studentService;
//     This is equivalent to controller function

    @Autowired
    public StudentController(StudentService studentService) {
        System.out.println("old" + studentService.hashCode());
        this.studentService = studentService;
        System.out.println("old" + this.studentService.hashCode());
    }

    @GetMapping
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
        return studentService.getStudents();

    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student){
        System.out.println(student);
        studentService.addNewStudent(student);
    }


//    path = {studentId}
//    /api/v1/student/studentId
    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId){
        studentService.deleteStudent(studentId);
    }

//    PUT

//    firing URL http://localhost:8080/api/v1/student/2?name="ash"
    @PutMapping(path = "{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email) {
        studentService.updateStudent(studentId, name, email);
    }



}
