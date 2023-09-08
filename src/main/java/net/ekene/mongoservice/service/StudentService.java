package net.ekene.mongoservice.service;

import net.ekene.mongoservice.model.Student;
import net.ekene.mongoservice.utility.StudentDTO;

import java.util.List;

public interface StudentService {
    Student addStudent (StudentDTO student);
    Student getStudent (String studentId);
    List<Student> getAllStudent ();
}
