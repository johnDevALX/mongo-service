package net.ekene.mongoservice.controller;

import lombok.RequiredArgsConstructor;
import net.ekene.mongoservice.model.Student;
import net.ekene.mongoservice.service.StudentServiceImpl;
import net.ekene.mongoservice.utility.StudentDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vi/mongoService/")
public class StudentController {
    private final StudentServiceImpl studentService;

    @PostMapping("add")
    public ResponseEntity<String> addStudent(@RequestBody StudentDTO student){
        Student student1 = studentService.addStudent(student);
        return new ResponseEntity<>(student1.getEmail(), HttpStatus.CREATED);
    }

    @GetMapping("getStudent/{studentId}")
    public ResponseEntity<Student> getStudentByID(@PathVariable(value = "studentId") String studentId){
        return new ResponseEntity<>(studentService.getStudent(studentId), HttpStatus.OK);
    }

    @GetMapping("getStudents")
    public ResponseEntity<List<Student>> getStudents(){
        return new ResponseEntity<>(studentService.getAllStudent(), HttpStatus.OK);
    }
}
